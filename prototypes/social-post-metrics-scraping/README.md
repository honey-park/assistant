# Social Post Metrics Scraping POC

## Goal
Provide comprehensive, centralized data collection for post metrics to support Social Starter analytics reports.

## Scope
- **Initial focus**: Instagram Native accounts
- **Future**: Facebook, Instagram via Meta, LinkedIn, TikTok
- **Posts included**: Both CTCT-created AND platform-native posts

## Architecture

### Database (social-reach-svc)
**Table**: `post_metrics` (already created in PR #1219)

```sql
CREATE TABLE post_metrics (
  post_metric_id BINARY(16) PRIMARY KEY,
  account_id BIGINT NOT NULL,
  post_id VARCHAR(255) NOT NULL,
  post_url VARCHAR(500),
  platform VARCHAR(32) NOT NULL, -- 'instagramnative', 'instagram', 'facebook', etc.
  post_type VARCHAR(32),           -- 'Image', 'Video', 'Carousel', etc.
  posted_at TIMESTAMP NOT NULL,

  -- Metrics
  impressions INT,
  reach INT,
  likes INT,
  comments INT,
  shares INT,
  saves INT,

  campaign_tag VARCHAR(255),
  scrape_status VARCHAR(32) NOT NULL DEFAULT 'PENDING',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  UNIQUE KEY (account_id, post_id, platform)
);
```

### Backend Endpoint (social-reach-svc)

**Endpoint**: `POST /v1/accounts/{accountId}/post-metrics/scrape?platform={platform}`

**Flow**:
1. Get OAuth token from token-svc for account/platform
2. Call Instagram Graph API to fetch posts from last 30 days
3. For each post, fetch insights/metrics
4. Store in post_metrics table
5. Return status (COMPLETED/FAILED) with count

**Response**:
```json
{
  "status": "COMPLETED",
  "totalPostsScraped": 15,
  "message": "Successfully scraped 15 posts"
}
```

### Rise-Adapter Mapping

Add endpoint mapping to expose to rise-ui:
```
POST /api/social-reach/accounts/{accountId}/post-metrics/scrape
```

### Frontend (rise-ui)

**Trigger**: On successful Instagram Native account connection
```typescript
// After connection success
await fetch(`/api/social-reach/accounts/${accountId}/post-metrics/scrape?platform=instagramnative`, {
  method: 'POST'
});
```

## Implementation Components

### 1. PostMetric Entity
- JPA entity mapping to post_metrics table
- Standard getters/setters
- Uses UUID for primary key

### 2. PostMetricRepository
- Extends JpaRepository<PostMetric, UUID>
- Query methods for account/platform filtering

### 3. PostMetricsScrapingService
- Core logic for scraping
- Integrates with token-svc
- Calls Instagram Graph API
- Maps response to PostMetric entities

### 4. PostMetricsController
- REST endpoint at `/v1/accounts/{accountId}/post-metrics/scrape`
- Validates input
- Returns status response

### 5. DTOs
- PostMetricsScrapingResponseDto (status, count, message)

## Instagram API Integration

### Endpoints Needed
```
# Get user's media
GET /me/media?since={30_days_ago}&access_token={token}

# Get insights for each media
GET /{media_id}/insights?metric=impressions,reach,likes,comments,shares,saved&access_token={token}
```

### Platform Identifiers
- **Instagram Native**: network=`instagramnative`, providerId=`instagram` (token-svc)

## Implementation Steps

1. ✅ Database table created (PR #1219 with safety guard)
2. Create Entity + Repository (social-reach-svc)
3. Create Service with Instagram API integration (social-reach-svc)
4. Create Controller endpoint (social-reach-svc)
5. Add rise-adapter mapping
6. Add frontend call in rise-ui on account connection success
7. Test end-to-end flow

## Open Questions

1. Should scraping be synchronous or async? (Consider Quartz job for async)
2. How to handle rate limits from Instagram API?
3. Should we retry failed scrapes automatically?
4. How to notify user when scraping completes (if async)?

## Safety Notes

⚠️ **Database Migration Safety**: PR #1219 has a safety guard in DatabaseConfiguration.java that prevents production database changes. Remove before merging to master.

## Files Location

Implementation files go in:
- **social-reach-svc** repo (not this prototypes folder)
- Follow existing package structure
- See social-reach-svc/AGENTS.md for conventions

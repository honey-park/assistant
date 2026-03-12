# How to Run the POC

## Prerequisites
- Java 11+
- Maven

## Steps

1. **Build the project**:
   ```bash
   cd /Users/honeypark/Projects/assistant/prototypes/social-post-metrics-scraping
   mvn clean install
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   Application starts on http://localhost:8081

3. **Test the scraping endpoint**:
   ```bash
   # Trigger scraping
   curl -X POST "http://localhost:8081/v1/accounts/123/post-metrics/scrape?platform=instagramnative"

   # Expected response:
   # {
   #   "status": "COMPLETED",
   #   "totalPostsScraped": 5,
   #   "message": "Successfully scraped 5 posts"
   # }
   ```

4. **View scraped metrics**:
   ```bash
   curl "http://localhost:8081/v1/accounts/123/post-metrics"
   ```

5. **Access H2 Console** (optional, for debugging):
   - URL: http://localhost:8081/h2-console
   - JDBC URL: `jdbc:h2:mem:postmetricsdb`
   - Username: `sa`
   - Password: (leave empty)

## What This POC Demonstrates

✅ REST endpoint for triggering scraping
✅ Database table structure for storing metrics
✅ Service layer for scraping logic
✅ Repository pattern for data access
✅ Response DTO with status indicator

## Mock Data

The POC generates 5 mock Instagram posts with:
- Random metrics (impressions, reach, likes, comments, shares, saves)
- Post dates within last 30 days
- Post types (Image/Video)

## Next Steps for Production

1. Replace mock data with actual Instagram Graph API calls
2. Integrate with token-svc for OAuth tokens
3. Handle rate limiting and pagination
4. Add async processing (Quartz jobs)
5. Implement in actual social-reach-svc repo

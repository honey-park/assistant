package com.ctct.poc.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "post_metrics")
public class PostMetric {

    @Id
    private String postMetricId;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private String postId;

    private String postUrl;

    @Column(nullable = false)
    private String platform;

    private String postType;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedAt;

    private Integer impressions;
    private Integer reach;
    private Integer likes;
    private Integer comments;
    private Integer shares;
    private Integer saves;

    private String campaignTag;

    @Column(nullable = false)
    private String scrapeStatus = "PENDING";

    public PostMetric() {
        this.postMetricId = UUID.randomUUID().toString();
    }

    // Getters and Setters
    public String getPostMetricId() { return postMetricId; }
    public void setPostMetricId(String postMetricId) { this.postMetricId = postMetricId; }

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public String getPostUrl() { return postUrl; }
    public void setPostUrl(String postUrl) { this.postUrl = postUrl; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getPostType() { return postType; }
    public void setPostType(String postType) { this.postType = postType; }

    public Date getPostedAt() { return postedAt; }
    public void setPostedAt(Date postedAt) { this.postedAt = postedAt; }

    public Integer getImpressions() { return impressions; }
    public void setImpressions(Integer impressions) { this.impressions = impressions; }

    public Integer getReach() { return reach; }
    public void setReach(Integer reach) { this.reach = reach; }

    public Integer getLikes() { return likes; }
    public void setLikes(Integer likes) { this.likes = likes; }

    public Integer getComments() { return comments; }
    public void setComments(Integer comments) { this.comments = comments; }

    public Integer getShares() { return shares; }
    public void setShares(Integer shares) { this.shares = shares; }

    public Integer getSaves() { return saves; }
    public void setSaves(Integer saves) { this.saves = saves; }

    public String getCampaignTag() { return campaignTag; }
    public void setCampaignTag(String campaignTag) { this.campaignTag = campaignTag; }

    public String getScrapeStatus() { return scrapeStatus; }
    public void setScrapeStatus(String scrapeStatus) { this.scrapeStatus = scrapeStatus; }
}

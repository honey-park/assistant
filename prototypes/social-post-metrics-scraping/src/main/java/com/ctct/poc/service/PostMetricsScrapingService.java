package com.ctct.poc.service;

import com.ctct.poc.entity.PostMetric;
import com.ctct.poc.repository.PostMetricRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostMetricsScrapingService {

    private static final Logger log = LoggerFactory.getLogger(PostMetricsScrapingService.class);

    @Autowired
    private PostMetricRepository repository;

    public int scrapePostMetrics(Long accountId, String platform) {
        log.info("Starting scrape for accountId={}, platform={}", accountId, platform);

        // POC: Generate mock data for last 30 days
        List<PostMetric> metrics = generateMockMetrics(accountId, platform, 5);

        repository.saveAll(metrics);

        log.info("Scraped {} posts for accountId={}", metrics.size(), accountId);
        return metrics.size();
    }

    private List<PostMetric> generateMockMetrics(Long accountId, String platform, int count) {
        List<PostMetric> metrics = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            PostMetric metric = new PostMetric();
            metric.setAccountId(accountId);
            metric.setPostId("post_" + UUID.randomUUID().toString().substring(0, 8));
            metric.setPostUrl("https://instagram.com/p/" + metric.getPostId());
            metric.setPlatform(platform);
            metric.setPostType(i % 2 == 0 ? "Image" : "Video");

            // Random date within last 30 days
            cal.add(Calendar.DAY_OF_MONTH, -random.nextInt(30));
            metric.setPostedAt(cal.getTime());
            cal = Calendar.getInstance(); // Reset

            // Mock metrics
            metric.setImpressions(random.nextInt(5000) + 100);
            metric.setReach(random.nextInt(3000) + 50);
            metric.setLikes(random.nextInt(500) + 10);
            metric.setComments(random.nextInt(50) + 1);
            metric.setShares(random.nextInt(20));
            metric.setSaves(random.nextInt(30));

            metric.setScrapeStatus("COMPLETED");
            metrics.add(metric);
        }

        return metrics;
    }
}

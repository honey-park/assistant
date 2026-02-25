package com.ctct.poc.controller;

import com.ctct.poc.dto.ScrapeResponseDto;
import com.ctct.poc.entity.PostMetric;
import com.ctct.poc.repository.PostMetricRepository;
import com.ctct.poc.service.PostMetricsScrapingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts/{accountId}/post-metrics")
public class PostMetricsController {

    private static final Logger log = LoggerFactory.getLogger(PostMetricsController.class);

    @Autowired
    private PostMetricsScrapingService scrapingService;

    @Autowired
    private PostMetricRepository repository;

    @PostMapping("/scrape")
    public ResponseEntity<ScrapeResponseDto> triggerScraping(
            @PathVariable Long accountId,
            @RequestParam String platform) {

        log.info("POST /v1/accounts/{}/post-metrics/scrape?platform={}", accountId, platform);

        try {
            int count = scrapingService.scrapePostMetrics(accountId, platform);
            return ResponseEntity.ok(new ScrapeResponseDto(
                    "COMPLETED",
                    count,
                    String.format("Successfully scraped %d posts", count)
            ));
        } catch (Exception e) {
            log.error("Error scraping metrics", e);
            return ResponseEntity.internalServerError().body(new ScrapeResponseDto(
                    "FAILED",
                    0,
                    "Error: " + e.getMessage()
            ));
        }
    }

    @GetMapping
    public ResponseEntity<List<PostMetric>> getMetrics(@PathVariable Long accountId) {
        return ResponseEntity.ok(repository.findByAccountId(accountId));
    }
}

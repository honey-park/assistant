package com.ctct.poc.dto;

public class ScrapeResponseDto {
    private String status;
    private Integer totalPostsScraped;
    private String message;

    public ScrapeResponseDto(String status, Integer totalPostsScraped, String message) {
        this.status = status;
        this.totalPostsScraped = totalPostsScraped;
        this.message = message;
    }

    // Getters
    public String getStatus() { return status; }
    public Integer getTotalPostsScraped() { return totalPostsScraped; }
    public String getMessage() { return message; }
}

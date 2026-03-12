package com.ctct.poc.repository;

import com.ctct.poc.entity.PostMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMetricRepository extends JpaRepository<PostMetric, String> {
    List<PostMetric> findByAccountId(Long accountId);
    List<PostMetric> findByAccountIdAndPlatform(Long accountId, String platform);
}

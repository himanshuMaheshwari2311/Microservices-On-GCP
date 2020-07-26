package com.stark.profileservice.service;

import com.stark.profileservice.model.Profile;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service("getprofile")
public class ProfileServiceImpl implements ProfileService {

    private RestTemplate restTemplate;

    @Autowired
    public ProfileServiceImpl(RestTemplate restTemplate) {
        this.restTemplate =  restTemplate;
    }

    @Override
    public Profile create(String emailId) {
        return null;
    }

    @Override
    public Profile get(String emailId) {
        return null;
    }

    @Override
    public Profile update(Profile profile) {
        return null;
    }

    @Override
    public boolean delete(String emailId) {
        return false;
    }

    @Override
    @CircuitBreaker(name="getprofile", fallbackMethod="fallbackTestService")
    @RateLimiter(name = "getprofile", fallbackMethod = "rateLimiterfallback")
    @Retry(name = "retryGetprofile", fallbackMethod = "retryfallback")
    @Bulkhead(name = "bulkheadGetProfile", fallbackMethod = "bulkHeadFallback")
    public String testService() {
        String s = restTemplate.getForObject("http://localhost:8080/hello-world", String.class);
        return s;
    }


    public String fallbackTestService(Throwable t) {
        System.out.println(t.getMessage());
        return "Internal service is down";
    }
    public String rateLimiterfallback(Throwable t) {
        System.out.println(t.getMessage());
        return "Inside rateLimiterfallback method. Some error occurred while calling service for seller registration";
    }
    public String bulkHeadFallback(Throwable t) {
        System.out.println(t.getMessage());
        return "Inside bulkHeadFallback method. Some error occurred while calling service for seller registration";
    }
    public String retryfallback(Throwable t) {
        System.out.println(t.getMessage());
        return "Inside retryfallback method. Some error occurred while calling service for seller registration";
    }
}

package com.example.demo1.insuremo;


import com.example.demo1.insuremo.externalService.ExternalServiceException;
import com.example.demo1.insuremo.response.UserData;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface MyApplicationService {
    @Cacheable(value = "externalResponseCache", key = "#userId", unless = "#result == null")
    UserData fetchUserData(String userId) throws ExternalServiceException;

    @CacheEvict(value = "externalResponseCache", key = "#userId")
    void evictUserData(String userId);
}

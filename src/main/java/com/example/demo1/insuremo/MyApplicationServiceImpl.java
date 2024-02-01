package com.example.demo1.insuremo;

import com.example.demo1.insuremo.externalService.ExternalService;
import com.example.demo1.insuremo.externalService.ExternalServiceException;
import com.example.demo1.insuremo.mapper.UserDataMapper;
import com.example.demo1.insuremo.response.UserData;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyApplicationServiceImpl implements MyApplicationService {
    private final ExternalService externalService;
    private final UserDataMapper userDataMapper;

    public MyApplicationServiceImpl(ExternalService externalService, UserDataMapper userDataMapper) {
        this.externalService = externalService;
        this.userDataMapper = userDataMapper;
    }

    @Override
    @Cacheable(value = "externalResponseCache", key = "#userId", unless = "#result == null")
    public UserData fetchUserData(String userId) throws ExternalServiceException {
        return externalService.fetchUserData(userId);
    }

    @Override
    @CacheEvict(value = "externalResponseCache", key = "#userId")
    public void evictUserData(String userId) {
        // No implementation needed, @CacheEvict will handle cache eviction
    }
}
package com.example.demo1.insuremo.externalService;

import com.example.demo1.insuremo.response.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalServiceImpl implements ExternalService {
    private final RestTemplate restTemplate;

    public ExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserData fetchUserData(String userId) throws ExternalServiceException {
        try {
            String apiUrl = "http://external-api/users/{userId}";
            return restTemplate.getForObject(apiUrl, UserData.class, userId);
        } catch (RestClientException e) {
            throw new ExternalServiceException("Failed to fetch user data from external service", e);
        }
    }
}
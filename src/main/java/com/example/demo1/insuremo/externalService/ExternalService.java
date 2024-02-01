package com.example.demo1.insuremo.externalService;

import com.example.demo1.insuremo.response.UserData;

public interface ExternalService {
    UserData fetchUserData(String userId) throws ExternalServiceException;
}

package com.example.demo1.insuremo.mapper;

import com.example.demo1.insuremo.response.UserData;
import com.example.demo1.insuremo.dtos.UserDataDTO;
import com.example.demo1.insuremo.dtos.UserDataExtendedDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDataMapperImpl implements UserDataMapper {

    @Override
    public UserDataDTO mapToUserDataDTO(UserData userData) {
        UserDataDTO dto = new UserDataDTO();
        dto.setUserId(userData.getUserId());
        dto.setUsername(userData.getUsername());
        return dto;
    }

    @Override
    public UserDataExtendedDTO mapToUserDataExtendedDTO(UserData userData) {
        UserDataExtendedDTO dto = new UserDataExtendedDTO();
        dto.setUserId(userData.getUserId());
        dto.setUsername(userData.getUsername());
        dto.setEmail(userData.getEmail());
        return dto;
    }
}
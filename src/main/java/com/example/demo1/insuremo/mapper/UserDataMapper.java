package com.example.demo1.insuremo.mapper;

import com.example.demo1.insuremo.response.UserData;
import com.example.demo1.insuremo.dtos.UserDataDTO;
import com.example.demo1.insuremo.dtos.UserDataExtendedDTO;

public interface UserDataMapper {
    //Controller Call Yapılacak
    UserDataDTO mapToUserDataDTO(UserData userData);
    UserDataExtendedDTO mapToUserDataExtendedDTO(UserData userData);
}
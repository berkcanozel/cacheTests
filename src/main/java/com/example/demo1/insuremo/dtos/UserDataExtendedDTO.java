package com.example.demo1.insuremo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataExtendedDTO {
    private Integer userId;
    private String username;
    private String email;
}

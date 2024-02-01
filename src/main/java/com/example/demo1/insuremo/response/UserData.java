package com.example.demo1.insuremo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    // Define properties of UserData
    private Integer userId;
    private String username;
    private String email;
}
package com.jony.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserEntity {

    private Long userId;
    private String userName;
    private Integer userAge;
    private String userSex;


}

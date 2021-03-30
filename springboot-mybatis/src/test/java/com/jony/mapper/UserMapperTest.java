package com.jony.mapper;

import com.jony.dao.UserMapper;
import com.jony.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAllUser() {
        List<UserEntity> list = userMapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    void getUserById() {
        UserEntity userEntity = userMapper.getUserById(2L);
        System.out.println(userEntity);
    }
}
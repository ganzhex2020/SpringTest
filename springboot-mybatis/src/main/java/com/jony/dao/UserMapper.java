package com.jony.dao;

import com.jony.model.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    @Results({
            @Result(property = "userId",  column = "id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "userAge", column = "age"),
            @Result(property = "userSex", column = "sex")
    })
    @Select("select * from user")
    List<UserEntity> getAllUser();

    @Results({
            @Result(property = "userId",  column = "id"),
            @Result(property = "userName", column = "name"),
            @Result(property = "userAge", column = "age"),
            @Result(property = "userSex", column = "sex")
    })
    @Select("select * from user where id = #{id}")
    UserEntity getUserById(@Param("id") Long id);

    @Insert("insert into user(name,age,sex) values(#{userName},#{userAge},#{userSex})")
    int insert(UserEntity userEntity);

    @Delete("delete from user where id = #{id}")
    int delete(Long id);

    @Update("UPDATE user SET name=#{userName},age=#{userAge} WHERE id =#{userId}")
    int update(UserEntity userEntity);
}

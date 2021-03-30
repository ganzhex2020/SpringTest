package com.jony.controller;

import com.jony.dao.UserMapper;
import com.jony.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class ApiTestController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/api/getUserList")
    public Object getAllUser() {
        List<UserEntity> list = userMapper.getAllUser();
        return list;
    }

    @RequestMapping("/api/getUser/{id}")
    public Object getUserById(@PathVariable("id") Long id) {
        UserEntity userEntity = userMapper.getUserById(id);
        return userEntity;
    }

    @RequestMapping("/api/add")
    public String add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("hooo");
        userEntity.setUserAge(18);
        userEntity.setUserSex("jjj");
        int reslut = userMapper.insert(userEntity);
        System.out.println(reslut);
        return "添加成功";
    }

    @GetMapping("/api/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        int result = userMapper.delete(id);
        System.out.println(result);
        return "删除成功";
    }

    @PostMapping("/api/update1")
    public String update1(@RequestParam("id") Long id,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age,
                         @RequestParam(name = "sex",required = false) String sex) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setUserName(name);
        userEntity.setUserAge(age);
        userEntity.setUserSex(sex);
        int result = userMapper.update(userEntity);
        System.out.println(result);
       return "success";

    }

    @PostMapping("/api/update2")
    public String update2(@RequestBody Map params) {

        Long id = Long.valueOf((Integer) params.get("id"));
        String name = (String) params.get("name");
        Integer age = (Integer) params.get("age");
        String sex = (String) params.get("sex");
        //System.out.println(params.get("id")+" "+params.get("name")+" "+params.get("age")+" "+params.get("sex"));

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setUserName(name);
        userEntity.setUserAge(age);
        userEntity.setUserSex(sex);
        int result = userMapper.update(userEntity);
        System.out.println(result);
        return "success";

    }


}

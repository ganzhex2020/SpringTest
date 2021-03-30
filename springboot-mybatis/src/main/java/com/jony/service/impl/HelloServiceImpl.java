package com.jony.service.impl;

import com.jony.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}

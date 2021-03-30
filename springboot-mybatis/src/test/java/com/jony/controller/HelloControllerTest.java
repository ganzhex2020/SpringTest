package com.jony.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest/*(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
class HelloControllerTest {

    /**
     *  注入一个web应用环境(容器)
     */
    /*@Resource
    private WebApplicationContext webApplicationContext;*/
    //mvc 环境对象
   /* @LocalServerPort
    private int port;*/

   /* @Autowired
    private TestRestTemplate restTemplate;*/

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    //    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hello() throws Exception {
        String str = mockMvc.perform(MockMvcRequestBuilders.get("/hello/jony")).andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andReturn().getResponse().getContentAsString();
        /*assert (this.restTemplate.getForObject("http://localhost:" + port + "/hello/World",
                String.class)).contains("Hello, World");*/

        System.out.println(str);


    }
}
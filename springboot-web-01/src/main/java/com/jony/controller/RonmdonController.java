package com.jony.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class RonmdonController {

    @RequestMapping("/api/{id}")
    public String getRomdon(@PathVariable("id") Integer id){
        if (id>10||id<1){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int i =1;i<11;i++){
            list.add(i);
        }
        list.remove(id);
        Collections.shuffle(list);
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer integer:list){
            stringBuffer.append(integer).append(" ");
        }
        return stringBuffer.toString();
    }
}

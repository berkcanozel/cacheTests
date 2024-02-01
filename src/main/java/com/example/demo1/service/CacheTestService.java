package com.example.demo1.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CacheTestService {

    public static HashMap prefixMap=new HashMap<>();

    @Cacheable(value = "microserviceResponses")
    public Object insertIntoCache(String endpoint,String param){
        String param1=param+" insertIntoCache1";

        return param1;
    }

    @Cacheable(value = "microserviceResponses2")
    public Object insertIntoCache2(String param){
        String param2=param+" insertIntoCache2";



        return param2;
    }

    @PostConstruct
    public void fillMap(){
        prefixMap.put("a","b");
    }


}

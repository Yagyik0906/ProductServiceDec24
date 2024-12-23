package com.yagyik.productservicedec24.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/hello/{name}/{noOfTimes}")
    public String sayHello(@PathVariable("name") String name,@PathVariable("noOfTimes") int noOfTimes){
        String res="";
        for(int i=0;i<noOfTimes;i++){
            String say="Hello "+name+"<br>";
            res+=say;
        }
        return res;
    }
}

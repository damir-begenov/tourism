package com.example.tourism;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String getAstana(){
        return "astana";
    }

}

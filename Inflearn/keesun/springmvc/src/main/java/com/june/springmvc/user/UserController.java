package com.june.springmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user/create")
    public @ResponseBody User create(@RequestBody User user){

        return  user;
    }


}

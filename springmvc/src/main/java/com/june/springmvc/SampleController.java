package com.june.springmvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/hellotemplate")
    public String hello(Model model){
        model.addAttribute("name" , "hyeonjung");
        return "hello";
    }

    @GetMapping("/helloexception")
    public String hell0Exception(){
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody
    ResponseEntity
}

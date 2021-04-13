package com.june.springhateoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.*;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public EntityModel<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("hyeonjung");

        EntityModel<Hello> helloEntityModel = new EntityModel<>(hello);
        helloEntityModel.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        return helloEntityModel;
    }
}

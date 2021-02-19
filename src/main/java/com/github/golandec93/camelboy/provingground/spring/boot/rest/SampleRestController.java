package com.github.golandec93.camelboy.provingground.spring.boot.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class SampleRestController {

    @RequestMapping(method = {GET, POST, PUT}, path = "echo")
    public String echo(@RequestBody String body){
        return body;
    }
}

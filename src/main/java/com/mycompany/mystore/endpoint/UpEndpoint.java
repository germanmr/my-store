package com.mycompany.mystore.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("up")
public class UpEndpoint {

    @GetMapping("/is")
    public String sayHi() {
        return "Hi from My Store Restful API!";
    }

}

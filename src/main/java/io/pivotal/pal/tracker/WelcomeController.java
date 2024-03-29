package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private String helloMsg;

    public WelcomeController(
            @Value("${welcome.message:NOT SET}") String helloMsg
    ) {
        this.helloMsg = helloMsg;
    }

    @GetMapping("/")
    public String sayHello() {
        return helloMsg;
    }
}
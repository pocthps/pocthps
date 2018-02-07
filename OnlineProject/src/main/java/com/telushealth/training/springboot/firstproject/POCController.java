package com.telushealth.training.springboot.firstproject;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class POCController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Greeting greeting(@RequestParam(value="name", defaultValue="POC") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
package org.tertortoise.blankspringserver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tertortoise.blankspringserver.resources.Greeting;

import java.util.concurrent.atomic.AtomicLong;
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class Controllers {

    private final AtomicLong greetingCounter = new AtomicLong();
    private static final String greetingTemplate = "Hello, %s!";

//    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(required = false, defaultValue = "Anonymous") String name) {

        System.out.println("==== get greeting ====");

        return new Greeting(greetingCounter.getAndIncrement(), String.format(greetingTemplate, name));

    }
}

package grapesu.example.calculator1.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @GetMapping(name="/")
    public String home() {
        return "Hello World";
    }
}

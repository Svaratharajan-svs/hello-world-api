package com.example.helloworldapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public ResponseEntity<Map<String, String>> hello(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid Input"));
        }

        char firstChar = Character.toUpperCase(name.charAt(0));
        if (firstChar >= 'A' && firstChar <= 'M') {
            String message = "Hello " + Character.toUpperCase(name.charAt(0)) + name.substring(1);
            return ResponseEntity.ok(Map.of("message", message));
        } else if (firstChar >= 'N' && firstChar <= 'Z') {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid Input"));
        } else {
            // Non-alphabetic case
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid Input"));
        }
    }
}

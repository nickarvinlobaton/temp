package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id) {
        return "Hello World! " + id;
    }

    @PostMapping("/")
    public String store(@RequestBody int id) {
        return "STORED " + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return "DELETED " + id;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id) {
        return "UPDATED " + id;
    }
}

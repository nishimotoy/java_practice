package com.example.kakeibo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KakeiboApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakeiboApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello 家計簿;
    }
}

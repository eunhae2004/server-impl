package com.koreait.testboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.koreait.testboard.repository") // Mapper가 있는 패키지
public class TestBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestBoardApplication.class, args);
    }
}
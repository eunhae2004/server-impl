package com.koreait.testboard.controller;

import com.koreait.testboard.domain.User;
import com.koreait.testboard.dto.UserLoginRequest;
import com.koreait.testboard.dto.UserRegisterRequest;
import com.koreait.testboard.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request,
                                        HttpSession session) {
        User user = userService.login(request.getUsername(), request.getPassword());

        // 세션에 로그인 정보 저장
        session.setAttribute("loginUser", user);

        return ResponseEntity.ok("로그인 성공");
    }

}

package com.koreait.testboard.service;

import com.koreait.testboard.domain.User;
import com.koreait.testboard.dto.UserRegisterRequest;
import com.koreait.testboard.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void register(UserRegisterRequest request){
//        중복 사용자 체크
        User existingUser = userMapper.findByUsername(request.getUsername());
        if(existingUser != null){
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();

        userMapper.insertUser(user);
    }

    public User login(String username, String password){
        User user = userMapper.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)){
            throw new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return user;
    }

}

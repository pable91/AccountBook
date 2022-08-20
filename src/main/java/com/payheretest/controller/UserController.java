package com.payheretest.controller;

import com.payheretest.dto.LoginUserDto;
import com.payheretest.dto.UserDto;
import com.payheretest.jwt.JwtTokenProvider;
import com.payheretest.model.User;
import com.payheretest.model.UserRoleEnum;
import com.payheretest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/user/signup")
    @ResponseBody
    public User signUp(@RequestBody UserDto userDto) {
        User user = userService.signup(userDto);

        return user;
    }

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginUserDto loginUserDto) {

        User user = userService.login(loginUserDto);
        String checkEmail = user.getEmail();
        UserRoleEnum role = user.getRole();

        String token = jwtTokenProvider.createToken(checkEmail, role);
//        response.setHeader("JWT", token);

        return ResponseEntity.ok().header("JWT", token).body(token);
    }

}
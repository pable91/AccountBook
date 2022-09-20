package com.AccountBook.controller;

import com.AccountBook.dto.LoginUserDto;
import com.AccountBook.jwt.JwtTokenProvider;
import com.AccountBook.dto.UserDto;
import com.AccountBook.model.User;
import com.AccountBook.model.response.SuccessResponse;
import com.AccountBook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/user/signup")
    @ResponseBody
    public ResponseEntity signUp(@RequestBody UserDto userDto) {
        User user = userService.signup(userDto);

        return SuccessResponse.toSignUpResponseEntity(user);
    }

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginUserDto loginUserDto) {
        User user = userService.login(loginUserDto);
        String checkEmail = user.getEmail();

        String token = jwtTokenProvider.createToken(checkEmail);

        return SuccessResponse.toLoginResponseEntity(token);
    }

    @PostMapping("/user/logout")
    public ResponseEntity logout() {

        // header 에 있는 토큰값을 빈값으로 만듬.
        String token = "";
        return SuccessResponse.toLogoutResponseEntity(token);
    }
}
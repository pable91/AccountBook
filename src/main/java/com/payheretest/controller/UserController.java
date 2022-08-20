package com.payheretest.controller;

import com.payheretest.dto.LoginUserDto;
import com.payheretest.dto.UserDto;
import com.payheretest.jwt.JwtTokenProvider;
import com.payheretest.model.User;
import com.payheretest.model.UserRoleEnum;
import com.payheretest.model.response.SuccessResponse;
import com.payheretest.service.UserService;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        UserRoleEnum role = user.getRole();

        String token = jwtTokenProvider.createToken(checkEmail, role);

        return SuccessResponse.toLoginResponseEntity(token);
    }

    @PostMapping("/user/logout")
    public ResponseEntity logout() {

        // header 에 있는 토큰값을 빈값으로 만듬.
        String token = "";
        return SuccessResponse.toLogoutResponseEntity(token);
    }
}
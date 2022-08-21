package com.payheretest.service;

import com.payheretest.model.response.ErrorCode;
import com.payheretest.exception.custom.SameEmailException;
import com.payheretest.model.User;
import com.payheretest.repository.UserRepository;
import com.payheretest.model.UserRoleEnum;
import com.payheretest.dto.LoginUserDto;
import com.payheretest.dto.UserDto;
import com.payheretest.exception.custom.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private static final String ADMIN_PW = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";


    public User signup(UserDto userDto) {
        String email = userDto.getEmail();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByEmail(email);
        if (found.isPresent()) {
            throw new SameEmailException(ErrorCode.SAME_EMAIL);
        }

        //패스워드 암호화
        String password = passwordEncoder.encode(userDto.getPassword());

        UserRoleEnum role = UserRoleEnum.ROLE_MEMBER;
//        if (userDto.isAdmin()) {
//            if (!userDto.getAdminToken().equals(ADMIN_PW)) {
//                throw new CustomException(ErrorCode.NO_MATCH_PASSWORD);
//            }
//            role = UserRoleEnum.ROLE_ADMIN;
//        }

        User user = new User(email, password, role);
        userRepository.save(user);
        return user;
    }

    //로그인
    public User login(LoginUserDto loginUserDto) {
        User user = userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.NO_USER)
        );
        if (!passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.NO_MATCH_PASSWORD);
        }
        return user;
    }
}

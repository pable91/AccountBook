package com.AccountBook.service;

import com.AccountBook.dto.LoginUserDto;
import com.AccountBook.exception.custom.NotFoundUserException;
import com.AccountBook.model.User;
import com.AccountBook.model.response.ErrorCode;
import com.AccountBook.repository.UserRepository;
import com.AccountBook.exception.custom.NoMatchPasswordException;
import com.AccountBook.exception.custom.SameEmailException;
import com.AccountBook.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(UserDto userDto) {
        String email = userDto.getEmail();

        Optional<User> found = userRepository.findByEmail(email);
        if (found.isPresent()) {
            throw new SameEmailException(ErrorCode.SAME_EMAIL);
        }

        String password = passwordEncoder.encode(userDto.getPassword());

//        UserRoleEnum role = UserRoleEnum.ROLE_MEMBER;

        User user = new User(email, password);
        userRepository.save(user);
        return user;
    }

    public User login(LoginUserDto loginUserDto) {
        User user = userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(
                () -> new NotFoundUserException(ErrorCode.NO_USER)
        );
        if (!passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            throw new NoMatchPasswordException(ErrorCode.NO_MATCH_PASSWORD);
        }
        return user;
    }
}

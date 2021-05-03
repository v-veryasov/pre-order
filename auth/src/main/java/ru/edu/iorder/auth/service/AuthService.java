package ru.edu.iorder.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.edu.iorder.auth.dto.MessageResponseDto;
import ru.edu.iorder.auth.dto.UserDto;
import ru.edu.iorder.auth.mapper.UserMapper;
import ru.edu.iorder.auth.model.User;
import ru.edu.iorder.auth.security.jwt.JwtTokenProvider;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;
    private final UserMapper userMapper;

    public boolean signUp(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return Optional.ofNullable(userService.register(user)).isPresent();
    }

    public MessageResponseDto signIn(UserDto reqDto) {
        try {
            String userName = reqDto.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, reqDto.getPassword()));
            User user = userService.findByUsername(userName);

            if (user == null) {
                throw new UsernameNotFoundException("User with userName: " + userName + " not found");
            }

            String token = jwtTokenProvider.createToken(userName, user.getRoles());

            return MessageResponseDto.builder()
                    .userName(userName)
                    .token(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}


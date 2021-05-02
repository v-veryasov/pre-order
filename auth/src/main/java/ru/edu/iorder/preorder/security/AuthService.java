package ru.edu.iorder.preorder.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.edu.iorder.preorder.dto.AuthReqDto;
import ru.edu.iorder.preorder.dto.AuthResDto;
import ru.edu.iorder.preorder.model.User;
import ru.edu.iorder.preorder.security.jwt.JwtTokenProvider;
import ru.edu.iorder.preorder.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthResDto signIn(AuthReqDto reqDto) {
        try {
            String userName = reqDto.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, reqDto.getPassword()));
            User user = userService.findByUsername(userName);

            if (user == null) {
                throw new UsernameNotFoundException("User with userName: " + userName + " not found");
            }

            String token = jwtTokenProvider.createToken(userName, user.getRoles());

            return AuthResDto.builder()
                    .userName(userName)
                    .token(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}


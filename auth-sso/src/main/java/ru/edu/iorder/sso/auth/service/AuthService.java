package ru.edu.iorder.sso.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.edu.iorder.sso.auth.dto.MessageResponseDto;
import ru.edu.iorder.sso.auth.dto.UserDto;
import ru.edu.iorder.sso.auth.mapper.UserMapper;
import ru.edu.iorder.sso.auth.model.User;
import ru.edu.iorder.sso.auth.security.AppUserAuthService;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    //private final AuthenticationManager authenticationManager;

    //private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;
    private final UserMapper userMapper;
    private final AppUserAuthService appUserAuthService;

    public boolean signUp(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return Optional.ofNullable(userService.register(user)).isPresent();
    }

    public MessageResponseDto signIn(UserDto reqDto) {
        User user = userService.findByUsername(reqDto.getUserName());
        return appUserAuthService.getToken(user);
        //try {
        //    String userName = reqDto.getUserName();
        //    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, reqDto.getPassword()));
        //    User user = userService.findByUsername(userName);
        //
        //    if (user == null) {
        //        throw new UsernameNotFoundException("User with userName: " + userName + " not found");
        //    }
        //
        //    String token = jwtTokenProvider.createToken(userName, user.getRoles());
        //
        //    return MessageResponseDto.builder()
        //            .userName(userName)
        //            .token(token)
        //            .build();
        //} catch (AuthenticationException e) {
        //    throw new BadCredentialsException("Invalid username or password");
        //}
    }
}


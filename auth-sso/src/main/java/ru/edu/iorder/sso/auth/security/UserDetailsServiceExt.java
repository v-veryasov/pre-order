package ru.edu.iorder.sso.auth.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.edu.iorder.sso.auth.model.User;
import ru.edu.iorder.sso.auth.service.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceExt implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        UserDetail userDetail = UserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return userDetail;
    }
}
package ru.edu.iorder.sso.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.iorder.sso.auth.model.Role;
import ru.edu.iorder.sso.auth.model.Status;
import ru.edu.iorder.sso.auth.model.User;
import ru.edu.iorder.sso.auth.repository.RoleRepository;
import ru.edu.iorder.sso.auth.repository.UserRepository;
import ru.edu.iorder.sso.auth.service.UserService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(Instant.now());
        user.setUpdated(Instant.now());

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser.getUserName());

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUserName(username);
        if (result != null) {
            log.info("IN findByUsername - user with id: {} found by username: {}", result.getId(), username);
        }
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }
}
package ru.edu.iorder.sso.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gate")
public class TestController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String create() {
        return "Test GATE!!!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createAdmin() {
        return "Test GATE!!!";
    }

    @GetMapping("/super/admin")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public String createSuperAdmin() {
        return "Test GATE!!!";
    }
}

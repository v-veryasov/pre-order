package ru.edu.iorder.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Role {
    USER(new HashSet<>(Collections.singletonList(Permission.READ))),
    ADMIN(new HashSet<>(Arrays.asList(Permission.READ, Permission.WRITE)));

    private final Set<Permission> permission;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Role{" +
                "permission=" + permission +
                '}';
    }
}

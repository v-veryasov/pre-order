package ru.edu.iorder.sso.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    READ("read"),
    WRITE("write");

    private final String permission;

}

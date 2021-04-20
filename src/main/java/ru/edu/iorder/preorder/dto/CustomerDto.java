package ru.edu.iorder.preorder.dto;

import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private long id;
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Instant registrationDate;
    private Instant lastActivityDate;
}

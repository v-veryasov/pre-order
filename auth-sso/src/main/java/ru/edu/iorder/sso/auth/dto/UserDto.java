package ru.edu.iorder.sso.auth.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Пользователь")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber; //NOT NULL
    private String userName; //NOT NULL
    private String password; //NOT NULL
    private String city; //NOT NULL
}

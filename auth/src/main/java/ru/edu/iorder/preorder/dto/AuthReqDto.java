package ru.edu.iorder.preorder.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Пользователь авторизации(запрос)")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthReqDto {

    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber; //NOT NULL
    private String userName; //NOT NULL
    private String password; //NOT NULL
}

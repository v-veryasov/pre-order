package ru.edu.iorder.preorder.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@ApiModel(description = "Пользователь")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @ApiModelProperty(notes = "Идентификатор")
    private long id;

    @ApiModelProperty(notes = "Логин пользователя")
    private String login;

    @ApiModelProperty(notes = "Пароль пользователя в зашифрованном виде")
    private String password;

    @ApiModelProperty(notes = "И пользователя")
    private String firstName;

    @ApiModelProperty(notes = "Ф пользователя")
    private String middleName;

    @ApiModelProperty(notes = "О пользователя")
    private String lastName;

    @ApiModelProperty(notes = "E-mail")
    private String email;

    @ApiModelProperty(notes = "Дата регистрации")
    private Instant registrationDate;

    @ApiModelProperty(notes = "Дата последнего действия")
    private Instant lastActivityDate;
}

package ru.edu.iorder.preorder.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Пользователь авторизации(ответ)")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResDto {

    private String userName;
    private String token;
}

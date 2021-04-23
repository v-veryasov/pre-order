package ru.edu.iorder.preorder.dto;

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
public class AuthReqDto {
    private String username;
    private String password;
}

package ru.edu.iorder.gateway.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
public class BookingController {

    @ApiOperation(value = "Создание нового пользователя")
    @GetMapping("/")
    public String create() {
        return "Test string form BookingController!!";
    }
}

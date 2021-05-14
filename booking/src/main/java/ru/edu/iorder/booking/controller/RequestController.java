package ru.edu.iorder.booking.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking/request")
public class RequestController {

    @ApiOperation(value = "Создание нового заказа")
    @GetMapping("/")
    public String create() {
        return "REQUEST form BookingController!!";
    }
}

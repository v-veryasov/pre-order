package ru.edu.iorder.booking.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking/price")
public class PriceController {

    @ApiOperation(value = "Создание нового прайса")
    @GetMapping("/")
    public String create() {
        return "PRICE form BookingController!!";
    }
}

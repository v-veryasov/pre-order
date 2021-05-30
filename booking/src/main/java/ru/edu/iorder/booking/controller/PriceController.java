package ru.edu.iorder.booking.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
public class PriceController {

    @ApiOperation(value = "Создание нового прайса")
    @GetMapping("/")
    public String create() {
        return "PRICE form BookingController!!";
    }

    @ApiOperation(value = "Создание нового пользователя")
    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createUser() {
        //var testStrBook =  bookingControllerProxy.create();
        return " !!!YES User!!! " + "Test string form ProfileController!!";
    }

    @ApiOperation(value = "Создание нового пользователя")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createAdmin() {
        //var testStrBook =  bookingControllerProxy.create();
        return " !!!YES ADMIN!!! " + "Test string form ProfileController!!";
    }
}

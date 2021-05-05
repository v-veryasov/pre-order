package ru.edu.iorder.profile.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.iorder.profile.proxy.BookingControllerProxy;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final BookingControllerProxy bookingControllerProxy;

    @ApiOperation(value = "Создание нового пользователя")
    @GetMapping("/")
    public String create() {
        var testStrBook =  bookingControllerProxy.create();
        return testStrBook + " !!!YES!!! " + "Test string form ProfileController!!";
    }
}

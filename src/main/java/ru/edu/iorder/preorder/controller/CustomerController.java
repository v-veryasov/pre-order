package ru.edu.iorder.preorder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.service.CustomerService;

@Api(value = "API Сервиса пользователей")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Создание нового пользователя
     */
    @ApiOperation(value = "Создание нового пользователя")
    @PostMapping("/")
    public CustomerDto create(@RequestBody CustomerDto dto) {
        return customerService.create(dto);
    }

    /**
     * Получение информации о пользователе по ID
     *
     * @param id - ID пользователя в БД
     */
    @ApiOperation(value = "Получение информации о пользователе по ID")
    @GetMapping("/{id}")
    public CustomerDto get(@ApiParam(value = "ID пользователя в БД", required = true)
                           @PathVariable Long id) {
        return customerService.getById(id);
    }
}

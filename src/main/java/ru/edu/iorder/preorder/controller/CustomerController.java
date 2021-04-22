package ru.edu.iorder.preorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.service.CustomerService;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Создание нового пользователя
     */
    @PostMapping("/")
    public CustomerDto create(@RequestBody CustomerDto dto) {
        return customerService.create(dto);
    }

    /**
     * Получение информации о пользователе по ID
     *
     * @param id - ID пользователя в БД
     */
    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable Long id) {
        return customerService.getById(id);
    }
}

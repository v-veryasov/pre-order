package ru.edu.iorder.preorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.iorder.preorder.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;


}

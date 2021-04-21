package ru.edu.iorder.preorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.mapper.CustomerMapper;
import ru.edu.iorder.preorder.model.Customer;
import ru.edu.iorder.preorder.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;
//    @Autowired
    private final CustomerMapper customerMapper;

    public CustomerDto create(CustomerDto dto) {
        Customer entity = customerRepository.save(customerMapper.customerDtoToCustomer(dto));
        return customerMapper.customerToCustomerDto(entity);
    }
}

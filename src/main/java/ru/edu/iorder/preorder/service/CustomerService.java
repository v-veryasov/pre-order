package ru.edu.iorder.preorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.mapper.CustomerMapper;
import ru.edu.iorder.preorder.model.Customer;
import ru.edu.iorder.preorder.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;
    public final CustomerMapper mapper;

    public CustomerDto create(CustomerDto dto) {
        Customer entity = customerRepository.save(mapper.customerDtoToCustomer(dto));
        return mapper.customerToCustomerDto(entity);
    }


}

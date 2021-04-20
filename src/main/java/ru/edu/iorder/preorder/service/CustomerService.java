package ru.edu.iorder.preorder.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.mapper.CustomerMapper;
import ru.edu.iorder.preorder.model.Customer;
import ru.edu.iorder.preorder.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;
//    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public CustomerDto create(CustomerDto dto) {
//        Customer entity = customerRepository.save(customerMapper.customerDtoToCustomer(dto));
//        return customerMapper.customerToCustomerDto(entity);
        return null;
    }
}

//package ru.edu.iorder.preorder.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import ru.edu.iorder.preorder.dto.CustomerDto;
//import ru.edu.iorder.preorder.mapper.CustomerMapper;
//import ru.edu.iorder.preorder.model.Customer;
//import ru.edu.iorder.preorder.repository.CustomerRepository;
//
//import javax.persistence.EntityExistsException;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class CustomerService {
//
//    public final CustomerRepository customerRepository;
//    private final CustomerMapper customerMapper;
//
//    public CustomerDto create(CustomerDto dto) {
//        Customer entity = customerRepository.save(customerMapper.customerDtoToCustomer(dto));
//        return customerMapper.customerToCustomerDto(entity);
//    }
//
//    public CustomerDto getById(Long id) {
//        log.info("#getById, id = {}", id);
//        Customer customer = customerRepository.findById(id)
//                .orElseThrow(EntityExistsException::new);
//
//        return customerMapper.customerToCustomerDto(customer);
//    }
//}
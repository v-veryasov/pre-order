package ru.edu.iorder.preorder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.edu.iorder.preorder.dto.CustomerDto;
import ru.edu.iorder.preorder.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    //    @Mappings({
//            @Mapping(target="id", source="entity.id"),
//            @Mapping(target="login", source="entity.login")
//    })
    @Mapping(target = "login", source = "login")
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}

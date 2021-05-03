package ru.edu.iorder.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.edu.iorder.auth.dto.CustomerDto;
import ru.edu.iorder.auth.model.Customer;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    //    @Mappings({
//            @Mapping(target="id", source="entity.id"),
//            @Mapping(target="login", source="entity.login")
//    })
//    @Mapping(target = "id", source = "customer.id")
    CustomerDto customerToCustomerDto(final Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer customerDtoToCustomer(final CustomerDto dto);
}

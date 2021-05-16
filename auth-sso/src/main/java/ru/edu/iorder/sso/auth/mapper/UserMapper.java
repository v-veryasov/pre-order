package ru.edu.iorder.sso.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.edu.iorder.sso.auth.dto.UserDto;
import ru.edu.iorder.sso.auth.model.User;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(final User user);

    //@Mapping(target = "id", ignore = true)
    User userDtoToUser(final UserDto dto);
}


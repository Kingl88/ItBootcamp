package by.test.service.mappers;

import by.test.api.UserDto;
import by.test.db.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto mapToDto(User entity);

    User mapFromDto(UserDto dto);
}

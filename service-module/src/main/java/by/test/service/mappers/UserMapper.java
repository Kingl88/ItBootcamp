package by.test.service.mappers;

import by.test.api.UserDto;
import by.test.db.entities.User;
import by.test.service.services.interfaces.RoleService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected RoleMapper roleMapper;
    @Mapping(target = "fio", expression = "java(new StringBuilder(entity.getName()).append(' ').append(entity.getLastname()).append(' ').append(entity.getSurname()).toString())")
    @Mapping(target = "role", source = "role.name")
    public abstract UserDto mapToDto(User entity);

    @Mapping(target = "role", expression = "java(roleMapper.mapFromDto(roleService.findByName(dto.getRole())))")
    public abstract User mapFromDto(UserDto dto);
}

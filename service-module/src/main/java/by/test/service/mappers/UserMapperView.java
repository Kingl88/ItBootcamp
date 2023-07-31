package by.test.service.mappers;

import by.test.api.dtoEntities.UserDtoView;
import by.test.db.entities.User;
import by.test.service.services.interfaces.RoleService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapperView {
    @Autowired
    protected RoleService roleService;

    @Mapping(target = "fio", expression = "java(new StringBuilder(entity.getSurname()).append(' ').append(entity.getName()).append(' ').append(entity.getLastname()).toString())")
    @Mapping(target = "role", source = "role.name")
    public abstract UserDtoView mapToDto(User entity);

}

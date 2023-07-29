package by.test.service.mappers;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.db.entities.User;
import by.test.service.services.interfaces.RoleService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapperSave {
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected RoleMapper roleMapper;

    @Mapping(target = "role", expression = "java(roleMapper.mapFromDto(roleService.findByName(dto.getRole())))")
    public abstract User mapFromDto(UserDtoSave dto);
}

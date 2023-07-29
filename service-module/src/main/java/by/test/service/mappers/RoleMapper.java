package by.test.service.mappers;

import by.test.api.dtoEntities.RoleDto;
import by.test.db.entities.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleDto mapToDto(Role entity);

    Role mapFromDto(RoleDto dto);
}

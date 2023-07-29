package by.test.service.services.interfaces;

import by.test.api.dtoEntities.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    RoleDto findByName(String name);
}

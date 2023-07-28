package by.test.service.services.interfaces;

import by.test.api.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findByName(String name);
    RoleDto save(RoleDto roleDto);
}

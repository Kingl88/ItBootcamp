package by.test.controllers;

import by.test.api.dtoEntities.RoleDto;
import by.test.service.services.interfaces.RoleService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Hidden
public class RoleControllerImpl {
    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }
}

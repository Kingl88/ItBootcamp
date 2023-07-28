package by.test.service.services;


import by.test.api.RoleDto;
import by.test.db.repositories.RoleRepository;
import by.test.service.mappers.RoleMapper;
import by.test.service.services.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto findByName(String name) {
        return roleMapper.mapToDto(roleRepository.findByName(name));
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        return roleMapper.mapToDto(roleRepository.save(roleMapper.mapFromDto(roleDto)));
    }
}

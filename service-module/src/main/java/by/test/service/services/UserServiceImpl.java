package by.test.service.services;

import by.test.api.UserDto;
import by.test.db.repositories.UserRepository;
import by.test.service.mappers.UserMapper;
import by.test.service.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.mapToDto(userRepository.save(userMapper.mapFromDto(userDto)));
    }
}

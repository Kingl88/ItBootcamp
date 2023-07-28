package by.test.service.services.interfaces;

import by.test.api.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto save(UserDto userDto);
}

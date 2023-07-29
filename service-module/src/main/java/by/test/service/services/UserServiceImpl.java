package by.test.service.services;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.db.repositories.UserRepository;
import by.test.service.mappers.UserMapperSave;
import by.test.service.mappers.UserMapperView;
import by.test.service.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapperView userMapperView;
    private final UserMapperSave userMapperSave;

    @Override
    public Page<UserDtoView> findAllSortByEmail(int pageIndex, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("email"))).map(userMapperView::mapToDto);
    }

    @Override
    public UserDtoView save(UserDtoSave userDto) {
        return userMapperView.mapToDto(userRepository.save(userMapperSave.mapFromDto(userDto)));
    }
}

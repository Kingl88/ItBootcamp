package by.test.service.services.interfaces;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<UserDtoView> findAllSortByEmail(int pageIndex, int pageSize);

    UserDtoView save(UserDtoSave userDto);
}

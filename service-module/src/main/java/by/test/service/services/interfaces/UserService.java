package by.test.service.services.interfaces;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.api.dtoEntities.PageDto;

public interface UserService {
    PageDto<UserDtoView> findAllSortByEmail(int pageIndex, int pageSize);

    UserDtoView save(UserDtoSave userDto);
}

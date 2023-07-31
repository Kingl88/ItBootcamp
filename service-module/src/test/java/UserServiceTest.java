import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.db.entities.Role;
import by.test.db.entities.User;
import by.test.db.repositories.UserRepository;
import by.test.service.mappers.UserMapperSave;
import by.test.service.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
public class UserServiceTest {
    private UserMapperSave userMapperSave;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void saveUser(){
        UserDtoSave userDtoSave = new UserDtoSave(null, "Kiril", "Anton", "ivanov", "rt@mail.ry", "Administrator");
        User user = new User(null, "Ivanov", "Kiril", "Anton", "rt@mail.ry", new Role("Administrator"));

        given(userRepository.save(userMapperSave.mapFromDto(userDtoSave))).willReturn(user);

        System.out.println(userRepository);
        System.out.println(userService);

        // when -  action or the behaviour that we are going test
        UserDtoView savedUser = userService.save(userDtoSave);

        System.out.println(savedUser);
        // then - verify the output
        assertThat(savedUser).isNotNull();
    }
}

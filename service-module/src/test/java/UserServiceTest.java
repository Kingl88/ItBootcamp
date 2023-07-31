import by.test.api.dtoEntities.PageDto;
import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.db.entities.Role;
import by.test.db.entities.User;
import by.test.db.repositories.UserRepository;
import by.test.service.mappers.UserMapperSave;
import by.test.service.mappers.UserMapperView;
import by.test.service.services.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.mockito.BDDMockito.given;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserMapperSave userMapperSave;
    @Mock
    private UserMapperView userMapperView;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @DisplayName("JUnit test for save User method")
    @Test
    public void saveUserTest() {
        UserDtoSave userDtoSave = new UserDtoSave(null, "Kiril", "Antonovich", "Ivanov", "rt@mail.ry", "Administrator");
        User user = new User(null, "Kiril", "Ivanov", "Antonovich", "rt@mail.ry", new Role("Administrator"));
        given(userMapperSave.mapFromDto(userDtoSave)).willReturn(user);
        given(userRepository.save(userMapperSave.mapFromDto(userDtoSave))).willReturn(user);
        given(userMapperView.mapToDto(user)).willReturn(new UserDtoView(null, "Ivanov Kiril Anton", "rt@mail.ry", "Administrator"));
        UserDtoView savedUser = userService.save(userDtoSave);
        log.log(Level.INFO, userRepository);
        log.log(Level.INFO, userService);
        log.log(Level.INFO, savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(savedUser.getEmail(), "rt@mail.ry");
        Assertions.assertEquals(savedUser.getFio(), "Ivanov Kiril Anton");
        Assertions.assertEquals(savedUser.getRole(), "Administrator");

    }

    @DisplayName("JUnit test for find all users sorting by email method")
    @Test
    public void findAllUserSortByEmail() {

        User user1 = new User(null, "Evgeni", "Petrov", "Antonovich", "Evgeni@mail.ry", new Role("Administrator"));
        given(userMapperView.mapToDto(user1)).willReturn(new UserDtoView(user1.getId(), (user1.getSurname() + " " + user1.getName() + " " + user1.getLastname()), user1.getEmail(), user1.getRole().getName()));
        User user2 = new User(null, "Anton", "Ivanov", "Antonovich", "Anton@mail.ry", new Role("Administrator"));

        log.log(Level.INFO, userMapperView.mapToDto(user1));

        given(userRepository.findAll()).willReturn(List.of(user1, user2));
        log.log(Level.INFO, userRepository.findAll());

        List<UserDtoView> userDtoViews = new ArrayList<>();

        log.log(Level.INFO, userMapperView.mapToDto(userRepository.findAll().get(0)));

        userDtoViews.add(userMapperView.mapToDto(userRepository.findAll().get(0)));

        given(userMapperView.mapToDto(user2)).willReturn(new UserDtoView(user2.getId(), (user2.getSurname() + " " + user2.getName() + " " + user2.getLastname()), user1.getEmail(), user2.getRole().getName()));

        log.log(Level.INFO, userMapperView.mapToDto(userRepository.findAll().get(1)));

        userDtoViews.add(userMapperView.mapToDto(userRepository.findAll().get(1)));

        log.log(Level.INFO, userDtoViews);
        PageDto<UserDtoView> pageDto = new PageDto<>(0, 3, userDtoViews, Comparator.comparing(UserDtoView::getEmail));

        log.log(Level.INFO, pageDto.getContent());

        Assertions.assertEquals(pageDto.getTotalElements(), 2);
        Assertions.assertEquals(pageDto.getTotalPages(), 1);
        Assertions.assertEquals(pageDto.getFirst(), true);
        Assertions.assertEquals(pageDto.getPageIndex(), 0);
        Assertions.assertEquals(pageDto.getContent().size(), 2);
    }
}

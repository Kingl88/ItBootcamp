package by.test.controllerTest;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.api.dtoEntities.PageDto;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.List;

@Log4j2
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
public class UserControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("classpath:schema.sql")
    @DisplayName(value = "getAllUsersPageTest with sorting by email")
    void getAllUsersPage() {
        PageDto<UserDtoView> page = testRestTemplate.exchange(
                "/api/v1/users?page=1&pageSize=10",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageDto<UserDtoView>>() {
                }).getBody();
        assert page != null;
        Assertions.assertEquals(page.getTotalElements(), 15);
        Assertions.assertEquals(page.getTotalPages(), 2);
        Assertions.assertEquals(page.getContent().get(0).getEmail(), "alex@mail.nt");
    }

    @Test
    @Sql("classpath:schema.sql")
    @DisplayName(value = "saveUserTest")
    void saveUser() {
        UserDtoSave userDtoSave = new UserDtoSave(null, "Pety", "Grisha", "Petrov", "231@jhg.ty", "Sale User");
        UserDtoView userDtoView = testRestTemplate.postForEntity(
                "/api/v1/users",
                userDtoSave,
                UserDtoView.class).getBody();
        PageDto<UserDtoView> page = testRestTemplate.exchange(
                "/api/v1/users?page=1",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageDto<UserDtoView>>() {
                }).getBody();
        assert userDtoView != null;
        Assertions.assertEquals(userDtoView.getEmail(), "231@jhg.ty");
        Assertions.assertEquals(userDtoView.getFio(), "Petrov Pety Grisha");
        Assertions.assertEquals(userDtoView.getRole(), "Sale User");
        assert page != null;
        Assertions.assertEquals(page.getTotalElements(), 16);
    }

    @Test
    @Sql("classpath:schema.sql")
    @DisplayName(value = "saveBadUserTest")
    void saveBadUser() {
        UserDtoSave userDtoSave = new UserDtoSave(null, "рол", "690гееукшпошщшкзешгук9геукгнщзшкешршщзрпрапргркенркрркпварправркерпрврпзварзварп", "rterte", "dfgdfgdmail.nt", "Sale User");
        List messages = testRestTemplate.postForEntity(
                "/api/v1/users",
                userDtoSave, List.class).getBody();
        PageDto<UserDtoView> page = testRestTemplate.exchange(
                "/api/v1/users?page=1",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageDto<UserDtoView>>() {
                }).getBody();
        assert messages != null;
        List<String> returnedList = List.of("Incorrect email",
                "Name should be contain only ASCII symbols",
                "Lastname should be contain only ASCII symbols",
                "The length of lastname should be less then 20 characters");
        log.log(Level.INFO, Collections.disjoint(messages, returnedList));
        Assertions.assertFalse(Collections.disjoint(messages, returnedList));
        assert page != null;
        Assertions.assertEquals(page.getTotalElements(), 15);
    }
}

package by.test.controllerTest;

import by.test.api.dtoEntities.UserDtoView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
public class UserControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    @Sql("classpath:schema.sql")
    void getAllUsersPage() {
        Page<UserDtoView> page = testRestTemplate.exchange("/api/v1/users?page=1", HttpMethod.GET, null, new ParameterizedTypeReference<Page<UserDtoView>>() {
                })
                .getBody();
        assert page != null;
        Assertions.assertEquals(page.getTotalElements(), 15);
        Assertions.assertEquals(page.getTotalPages(), 2);
        Assertions.assertEquals(page.getContent().get(0).getEmail(), "alex@mail.nt");
            }
}

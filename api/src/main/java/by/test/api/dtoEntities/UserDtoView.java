package by.test.api.dtoEntities;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoView {
    private Long id;
    private String fio;
    private String email;
    private String role;
}

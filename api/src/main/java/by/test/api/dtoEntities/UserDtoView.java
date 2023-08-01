package by.test.api.dtoEntities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о пользователе для отображения", name = "UserDtoSave")
public class UserDtoView {
    @Schema(description = "Идентификатор пользователя", example = "null")
    private Long id;
    @Schema(description = "ФИО пользователя", example = "Sergey Ivanovich Petrov")
    private String fio;
    @Schema(description = "Почта пользователя", example = "test@mail.bi")
    private String email;
    @Schema(description = "Название роли пользователя", example = "Administrator")
    private String role;
}

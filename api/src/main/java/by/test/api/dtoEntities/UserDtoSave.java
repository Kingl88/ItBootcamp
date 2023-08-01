package by.test.api.dtoEntities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о пользователе для сохранения в базу", name = "UserDtoSave")
public class UserDtoSave {
    @Schema(description = "Идентификатор пользователя", example = "null")
    private Long id;
    @Length(max = 40, message = "The length of name should be less then 40 characters")
    @Pattern(regexp = "[ -~]+", message = "Name should be contain only ASCII symbols")
    @Schema(description = "Имя пользователя", example = "Sergey")
    private String name;
    @Length(max = 20, message = "The length of lastname should be less then 20 characters")
    @Pattern(regexp = "[ -~]+", message = "Lastname should be contain only ASCII symbols")
    @Schema(description = "Отчество пользователя", example = "Ivanovich")
    private String lastname;
    @Length(max = 40, message = "The length of surname should be less then 40 characters")
    @Pattern(regexp = "[ -~]+", message = "Surname should be contain only ASCII symbols")
    @Schema(description = "Фамилия пользователя", example = "Petrov")
    private String surname;
    @Length(max = 50, message = "The length of email should be less then 50 characters")
    @Email(message = "Incorrect email")
    @Schema(description = "Почта пользователя", example = "test@mail.bi")
    private String email;
    @Schema(description = "Название роли пользователя", example = "Administrator")
    private String role;
}

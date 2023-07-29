package by.test.api.dtoEntities;

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
public class UserDtoSave {
    private Long id;
    @Length(max = 40, message = "The length of name should be less then 40 characters")
    @Pattern(regexp = "[ -~]+", message = "Name should be contain only ASCII symbols")
    private String name;
    @Length(max = 20, message = "The length of lastname should be less then 20 characters")
    @Pattern(regexp = "[ -~]+", message = "Lastname should be contain only ASCII symbols")
    private String lastname;
    @Length(max = 40, message = "The length of surname should be less then 40 characters")
    @Pattern(regexp = "[ -~]+", message = "Surname should be contain only ASCII symbols")
    private String surname;
    @Length(max = 50, message = "The length of email should be less then 50 characters")
    @Email(message = "Incorrect email")
    private String email;
    private String role;
}

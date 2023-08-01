package by.test.api.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Hidden
public class DataValidationException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public DataValidationException(List<String> messages) {
        this.messages = messages;
    }
}

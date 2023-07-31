package by.test.api.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class DataValidationException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public DataValidationException(List<String> messages) {
        this.messages = messages;
    }
}

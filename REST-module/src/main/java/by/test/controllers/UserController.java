package by.test.controllers;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.api.exceptions.DataValidationException;
import by.test.service.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Page<UserDtoView> findAll(@RequestParam(name = "page", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return userService.findAllSortByEmail(pageIndex - 1, 10);
    }

    @PostMapping
    public UserDtoView save(@RequestBody @Validated UserDtoSave userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
        }
        return userService.save(userDto);
    }
}

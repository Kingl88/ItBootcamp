package by.test.controllers;

import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import by.test.api.exceptions.DataValidationException;
import by.test.api.dtoEntities.PageDto;
import by.test.controllers.interfaces.UserController;
import by.test.service.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @GetMapping
    public PageDto<UserDtoView> findAll(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "pageSize", defaultValue = "1") int pageSize) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return userService.findAllSortByEmail(pageIndex - 1, pageSize);
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

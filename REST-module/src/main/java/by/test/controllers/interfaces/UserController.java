package by.test.controllers.interfaces;

import by.test.api.dtoEntities.PageDto;
import by.test.api.dtoEntities.UserDtoSave;
import by.test.api.dtoEntities.UserDtoView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user", description = "Контроллер для работы с пользователями")
public interface UserController {
    @Operation(
            operationId = "getPageWithListUsers",
            summary = "Получение определенной страницы с заданным количеством записей",
            tags = {"user"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Страница с заданным количеством записей", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    PageDto<UserDtoView> findAll(@RequestParam(name = "page", defaultValue = "1") int pageIndex,
                                 @RequestParam(name = "pageSize", defaultValue = "1") int pageSize);

    @Operation(
            operationId = "saveUser",
            summary = "Добавление пользователя",
            tags = {"user"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Пользователь успешно добавлен", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDtoSave.class))
                    })
            }
    )
    @PostMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
            @Content(mediaType = "application/json")
    })
    @ResponseStatus(HttpStatus.CREATED)
    UserDtoView save(
            @Parameter(name = "user", description = "User item", required = true)
            @RequestBody UserDtoSave userDtoSave, BindingResult bindingResult
    );
}

package by.test.api.dtoEntities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@Schema(description = "Информация о странице с данными", name = "PageDto")
public class PageDto<T> {
    @Schema(description = "Список содержащий пользователей", example = "[]")
    private List<T> content;
    @Schema(description = "Номер страницы", example = "1")
    private Integer pageIndex;
    @Schema(description = "Является ли страница первой", example = "true")
    private Boolean first;
    @Schema(description = "Является ли страница последней", example = "false")
    private Boolean last;
    @Schema(description = "Количество записей на странице", example = "true")
    private Integer pageSize;
    @Schema(description = "Количество страниц", example = "true")
    private Integer totalPages;
    @Schema(description = "Количество пользователей на всех страницах", example = "true")
    private Integer totalElements;

    public PageDto(Integer pageIndex, Integer pageSize, List<T> listElements) {
        this.totalElements = listElements.size();
        this.totalPages = (int) Math.ceil((double) listElements.size() / pageSize);
        if (pageIndex < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero");
        }

        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size must not be less than one");
        }
        if (pageIndex * pageSize > listElements.size()) {
            throw new IllegalArgumentException("Page index must be less or equals than " + totalPages);
        }
        this.content = new ArrayList<>();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.first = pageIndex == 0;
        this.last = pageIndex == listElements.size() / pageSize;
        int indexTo;
        int indexFrom;
        indexTo = Math.min((pageIndex + 1) * pageSize, listElements.size());
        if (pageSize > listElements.size()) {
            indexFrom = 0;
        } else {
            indexFrom = pageIndex * pageSize;
        }
        for (int i = indexFrom; i < indexTo; i++) {
            this.content.add(listElements.get(i));
        }
    }

    public PageDto(Integer pageIndex, Integer pageSize, List<T> listElements, Comparator<T> comparator) {
        this(pageIndex, pageSize, listElements);
        content.sort(comparator);
    }
}

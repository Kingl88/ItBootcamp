package by.test.api.dtoEntities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class PageDto<T> {
    private List<T> content;
    private Integer pageIndex;
    private Boolean first;
    private Boolean last;
    private Integer pageSize;
    private Integer totalPages;
    private Integer totalElements;
    public PageDto(Integer pageIndex, Integer pageSize, List<T> listElements) {
        if (pageIndex < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero");
        }

        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size must not be less than one");
        }
        this.content = new ArrayList<>();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.first = pageIndex == 0;
        this.last = pageIndex == listElements.size() / pageSize;
        this.totalPages = (int)Math.ceil((double) listElements.size() / pageSize) ;
        this.totalElements = listElements.size();
        int indexTo;
        if((pageIndex +1)*pageSize < listElements.size()){
            indexTo = (pageIndex +1)*pageSize;
        } else{
            indexTo = listElements.size();
        }
        for (int i = pageIndex*pageSize;i < indexTo; i++){
            this.content.add(listElements.get(i));
        }
    }
    public PageDto(Integer pageIndex, Integer pageSize, List<T> listElements, Comparator<T> comparator) {
        this(pageIndex, pageSize,listElements);
        content.sort(comparator);
    }
}

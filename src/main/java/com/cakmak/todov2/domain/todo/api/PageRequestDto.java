package com.cakmak.todov2.domain.todo.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@Getter
@Setter
public class PageRequestDto {
    private Integer pageNumber;
    private Integer pageSize;

    public Pageable getPageable(PageRequestDto dto){
        Integer pageNumber = Objects.nonNull(dto.getPageNumber()) ? dto.getPageNumber() : this.pageNumber;
        Integer pageSize = Objects.nonNull(dto.getPageSize()) ? dto.getPageNumber() : this.pageSize;

        PageRequest request = PageRequest.of(pageNumber , pageSize);

        return request;
    }
}

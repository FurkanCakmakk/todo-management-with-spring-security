package com.cakmak.todov2.domain.todo.api;

import com.cakmak.todov2.domain.todo.web.TodoRequest;
import com.cakmak.todov2.domain.todo.web.TodoResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class TodoMapper {

    private TodoMapper(){}

    public static TodoDto toDto(TodoRequest  request){
        return TodoDto.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .deadline(request.getDeadline())
                .priority(request.getPriority())
                .status(request.getStatus())
                .build();
    }

    public static TodoResponse toResponse(TodoDto dto){
        return TodoResponse.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .created(dto.getCreated())
                .deadline(dto.getDeadline())
                .priority(dto.getPriority())
                .status(dto.getStatus())
                .build();
    }

//    public static Page<TodoResponse> toPageResponse(Page<TodoDto> dtos){
//        return Page<dtos>
//    }

    public static List<TodoResponse> toResponse(List<TodoDto> dtos) {
        return dtos.stream().map(TodoMapper::toResponse).toList();
    }
}

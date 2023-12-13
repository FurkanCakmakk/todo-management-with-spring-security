package com.cakmak.todov2.domain.todo.impl;

import com.cakmak.todov2.domain.todo.api.TodoDto;

public class TodoMapper {

    public static TodoDto toDto(Todo todo){
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .created(todo.getCreated())
                .deadline(todo.getDeadline())
                .priority(todo.getPriority())
                .status(todo.getStatus())
                .build();
    }


    public static Todo toEntity(Todo todo , TodoDto dto){
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setDeadline(dto.getDeadline());
        todo.setPriority(dto.getPriority());
        todo.setStatus(dto.getStatus());

        return todo;
    }
}

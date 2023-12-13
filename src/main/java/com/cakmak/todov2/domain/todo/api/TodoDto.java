package com.cakmak.todov2.domain.todo.api;

import com.cakmak.todov2.domain.todo.impl.enums.TodoPriority;
import com.cakmak.todov2.domain.todo.impl.enums.TodoStatus;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoDto {
    private String id;
    private String title;
    private String description;
    private Date created;
    private Date deadline;
    private TodoPriority priority;
    private TodoStatus status;
}

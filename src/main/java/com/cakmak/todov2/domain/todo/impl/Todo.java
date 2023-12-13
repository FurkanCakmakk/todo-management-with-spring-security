package com.cakmak.todov2.domain.todo.impl;

import com.cakmak.todov2.domain.todo.impl.enums.TodoPriority;
import com.cakmak.todov2.domain.todo.impl.enums.TodoStatus;
import com.cakmak.todov2.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = Todo.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Todo extends AbstractEntity {
    public static final String TABLE = "todo";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String DEADLINE = "deadline";
    private static final String PRIORITY = "priority";
    private static final String STATUS = "status";
    private static final String ASSIGNMENT_TO_USER = "assignment_to_user";

    @Column(name = TITLE)
    private String title;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = DEADLINE)
    private Date deadline;

    @Column(name = PRIORITY)
    private TodoPriority priority;

    @Column(name = STATUS)
    private TodoStatus status;

//    @Column(name = ASSIGNMENT_TO_USER)
//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> assignmentToUser;


}

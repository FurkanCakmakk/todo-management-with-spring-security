package com.cakmak.todov2.domain.todo.impl;

import com.cakmak.todov2.domain.todo.impl.enums.TodoPriority;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo , String> , JpaSpecificationExecutor<Todo> {

List<Todo> findAllByPriority(String priority , Pageable pageable);
}

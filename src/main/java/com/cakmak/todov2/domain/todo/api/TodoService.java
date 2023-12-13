package com.cakmak.todov2.domain.todo.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {
    Page<TodoDto> getAllTodosByQuery(String pageNumber , String pageSize);
    Page<TodoDto> getAllTodosByPagination(Pageable pageable);
    Page<TodoDto> getAllTodosByPagination(String pageNumber, String pageSize);

    Page<TodoDto> getAllTodosByPaginationAndSortingWithQuery(String pageNumber ,String pageSize, String sortBy , String sortDir);

    Page<TodoDto> findProductsWithPaginationAndSorting(String pageNumber, String pageSize, String field);

    List<TodoDto> getAllByPriority(String priority, Pageable pageable);

    TodoDto getById(String id);

    TodoDto save(TodoDto dto);

    TodoDto update(String id, TodoDto dto);

    void delete(String id);

    List<TodoDto> getAll();


}

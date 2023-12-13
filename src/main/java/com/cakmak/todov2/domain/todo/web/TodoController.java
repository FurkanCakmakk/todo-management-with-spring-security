package com.cakmak.todov2.domain.todo.web;

import com.cakmak.todov2.domain.todo.api.TodoMapper;
import com.cakmak.todov2.domain.todo.api.TodoService;
import com.cakmak.todov2.library.rest.*;
import com.cakmak.todov2.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController extends BaseController {
    private final TodoService service;


    @PostMapping
    public Response<TodoResponse> createTodo(@RequestBody TodoRequest request) {
        return respond(TodoMapper.toResponse(service.save(TodoMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    public Response<TodoResponse> getTodoById(@PathVariable String id) {
        return respond(TodoMapper.toResponse(service.getById(id)));
    }

    @GetMapping()
    public Response<DataResponse<TodoResponse>> getAllTodos() {
        return respond(service.getAll().stream().map(dto -> TodoMapper.toResponse(dto)).collect(Collectors.toList()));
    }

    @GetMapping("/with-page")
    public Response<PageResponse<TodoResponse>> getAllTodosByPagination(Pageable pageable) {
        return respond(service.getAllTodosByPagination(pageable).map(dto -> TodoMapper.toResponse(dto)));
    }


    @GetMapping("{pageNumber}/{pageSize}")
    public Response<PageResponse<TodoResponse>> getAllTodosByPagination(@PathVariable String pageNumber, @PathVariable String pageSize) {
        return respond(service.getAllTodosByPagination(pageNumber, pageSize).map(dto -> TodoMapper.toResponse(dto)));
    }

    @GetMapping("/with-query")
    public Response<PageResponse<TodoResponse>> getAllTodosByQuery(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) String pageSize
    ) {
        return respond(service.getAllTodosByQuery(pageNumber, pageSize).map(dto -> TodoMapper.toResponse(dto)));
    }

    @GetMapping("/with-page-sort")
    public Response<PageResponse<TodoResponse>> getAllTodosByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
    ) {
        return respond(service.getAllTodosByPaginationAndSortingWithQuery(pageNumber , pageSize,sortBy , sortDir).map(dto -> TodoMapper.toResponse(dto)));
    }

    @PutMapping("/{id}")
    public Response<TodoResponse> updateTodo(@PathVariable String id, @RequestBody TodoRequest request) {
        return respond(TodoMapper.toResponse(service.update(id, TodoMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteTodoById(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }


}

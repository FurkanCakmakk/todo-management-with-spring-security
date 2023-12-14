package com.cakmak.todov2.domain.todo.impl;

import com.cakmak.todov2.domain.todo.api.TodoDto;
import com.cakmak.todov2.domain.todo.api.TodoService;
import com.cakmak.todov2.library.enums.MessageCodes;
import com.cakmak.todov2.library.exception.CoreException;
import com.cakmak.todov2.library.exceptiontutorial.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Override
    public List<TodoDto> getAll() {
        return repository.findAll().stream().map(todo -> TodoMapper.toDto(todo)).collect(Collectors.toList());
    }

    @Override
    public Page<TodoDto> getAllTodosByPagination(String pageNumber, String pageSize) {
        Page<TodoDto> todoDtoPage = repository.findAll(PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize)))
                .map(todo -> TodoMapper.toDto(todo));
        return todoDtoPage;
    }

    @Override
    public Page<TodoDto> getAllTodosByPaginationAndSortingWithQuery(String pageNumber, String pageSize, String sortBy , String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber),Integer.parseInt(pageSize), sort);
        return repository.findAll(pageable).map(todo -> TodoMapper.toDto(todo));
    }

    @Override
    public Page<TodoDto> getAllTodosByQuery(String pageNumber, String pageSize) {
        Pageable pageable  = PageRequest.of(Integer.parseInt(pageNumber) , Integer.parseInt(pageSize));
        Page<TodoDto> todoDtoPage = repository.findAll(pageable).map(todo -> TodoMapper.toDto(todo));
        return todoDtoPage;
    }


    @Override
    public Page<TodoDto> findProductsWithPaginationAndSorting(String pageNumber, String pageSize, String field) {
        Page<TodoDto> products = repository
                .findAll(PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize))
                        .withSort(Sort.by(field)))
                .map(todo -> TodoMapper.toDto(todo));
        return products;
    }

    @Override
    public Page<TodoDto> getAllTodosByPagination(Pageable pageable) {
        return repository.findAll(pageable).map(todo -> TodoMapper.toDto(todo));
    }


    @Override
    @Transactional
    public TodoDto update(String id, TodoDto dto) {
        Todo todo = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Todo.class.getSimpleName(), "id", id)
        );
        return TodoMapper.toDto(repository.save(setTodo(todo, dto)));
    }

    @Override
    @Transactional
    public void delete(String id) {
        var todo = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Todo.class.getSimpleName(), "id", id)
        );
        repository.delete(todo);
    }


    @Override
    public List<TodoDto> getAllByPriority(String priority, Pageable pageable) {
        List<TodoDto> todos = repository.findAllByPriority(priority, pageable).stream()
                .map(todo -> TodoMapper.toDto(todo))
                .collect(Collectors.toList());

        return todos;
    }


    @Override
    public TodoDto getById(String id) {
        System.out.println("Get ById metodunda hatadan gelenler " + MessageCodes.ENTITY_NOT_FOUND.getMessage() + " " + Todo.class.getSimpleName() + " " + id);
        return repository.findById(id).map(TodoMapper::toDto).orElseThrow(
                () -> new ResourceNotFoundException(Todo.class.getSimpleName(), "id", id)
        );
    }

    @Override
    @Transactional
    public TodoDto save(TodoDto dto) {
        return TodoMapper.toDto(repository.save(TodoMapper.toEntity(new Todo(), dto)));
    }


    private Todo setTodo(Todo todo, TodoDto dto) {
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setDeadline(dto.getDeadline());
        todo.setPriority(dto.getPriority());
        todo.setStatus(dto.getStatus());

        return todo;
    }
}

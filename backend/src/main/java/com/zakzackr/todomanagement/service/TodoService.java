package com.zakzackr.todomanagement.service;

import com.zakzackr.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService {

    // fixed
    TodoDto addTodo(Long userId, TodoDto todoDto);

    TodoDto getTodo(Long todoId, Long userId);

    List<TodoDto> getAllTodos(Long userId);

    TodoDto updateTodo(Long todoId, Long userId, TodoDto updatedDto);

    void deleteTodo(Long todoId, Long userId);

    TodoDto completeTodo(Long todoId, Long userId);

    TodoDto inCompleteTodo(Long todoId, Long userId);
}

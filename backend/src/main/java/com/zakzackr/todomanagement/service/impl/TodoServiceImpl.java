package com.zakzackr.todomanagement.service.impl;

import com.zakzackr.todomanagement.dto.TodoDto;
import com.zakzackr.todomanagement.entity.Todo;
import com.zakzackr.todomanagement.entity.User;
import com.zakzackr.todomanagement.exception.ResourceNotFoundException;
import com.zakzackr.todomanagement.repository.TodoRepository;
import com.zakzackr.todomanagement.repository.UserRepository;
import com.zakzackr.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(Long userId, TodoDto todoDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("The user with does not exist."));

        // converting TodoDto to Todo JPA entity
        Todo todo = modelMapper.map(todoDto, Todo.class);
        // when creating new task, save it with user obj, so that other CRUD operations will work correctly
        todo.setUser(user);
        Todo savedTodo = todoRepository.save(todo);

        // converting Todo JPA entity to TodoDto
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long todoId, Long userId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId).
                orElseThrow(() -> new ResourceNotFoundException("The task does not exist..."));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos(Long userId) {
        List<Todo> todos = todoRepository.findAllByUserId(userId);

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long todoId, Long userId, TodoDto todoDto) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("The todo task does not exist."));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long todoId, Long userId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("The todo task with does not exist."));

        todoRepository.deleteByIdAndUserId(todoId, userId);
    }

    @Override
    public TodoDto completeTodo(Long todoId, Long userId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("The todo task with does not exist."));

        todo.setCompleted(true);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long todoId, Long userId) {
        Todo todo = todoRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("The todo task with does not exist."));
        todo.setCompleted(false);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}

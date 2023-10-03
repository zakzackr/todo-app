package com.zakzackr.todomanagement.controller;

import com.zakzackr.todomanagement.dto.TodoDto;
import com.zakzackr.todomanagement.entity.Todo;
import com.zakzackr.todomanagement.entity.User;
import com.zakzackr.todomanagement.service.TodoService;
import com.zakzackr.todomanagement.service.impl.TodoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    // add todo REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/{userId}")
    public ResponseEntity<TodoDto> addTodo(@PathVariable Long userId,
                                           @RequestBody TodoDto todoDto){

        TodoDto saved = todoService.addTodo(userId, todoDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // get todo REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{userId}/{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId,
                                           @PathVariable Long userId){

        TodoDto todoDto = todoService.getTodo(todoId, userId);
        return ResponseEntity.ok(todoDto);
    }

    // get all todos REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable Long userId){

        List<TodoDto> todoDtos = todoService.getAllTodos(userId);
        return ResponseEntity.ok(todoDtos);
    }

    // update todo REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{userId}/{todoId}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long todoId,
                                              @PathVariable Long userId,
                                              @RequestBody TodoDto todoDto){

        TodoDto updated = todoService.updateTodo(todoId, userId, todoDto);
        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("{userId}/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long todoId,
                                             @PathVariable Long userId){
        todoService.deleteTodo(todoId, userId);

        return ResponseEntity.ok("Todo deleted successfully.");
    }

    // complete todo REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/{userId}/{todoId}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable Long todoId,
                                                @PathVariable Long userId){
        TodoDto updated = todoService.completeTodo(todoId, userId);
        return ResponseEntity.ok(updated);
    }

    // incomplete todo REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/{userId}/{todoId}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable Long todoId,
                                                  @PathVariable Long userId){
        TodoDto updated = todoService.inCompleteTodo(todoId, userId);
        return ResponseEntity.ok(updated);
    }
}

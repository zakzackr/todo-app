package com.zakzackr.todomanagement.controller;

import com.zakzackr.todomanagement.dto.TodoDto;
import com.zakzackr.todomanagement.entity.Todo;
import com.zakzackr.todomanagement.service.TodoService;
import com.zakzackr.todomanagement.service.impl.TodoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    // add todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto saved = todoService.addTodo(todoDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // get todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id){
        TodoDto todoDto = todoService.getTodo(id);
        return ResponseEntity.ok(todoDto);
    }

    // get all todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todoDtos = todoService.getAllTodos();
        return ResponseEntity.ok(todoDtos);
    }

    // update todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id,
                                              @RequestBody TodoDto todoDto){
        TodoDto updated = todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);

        return ResponseEntity.ok("The todo task with id " + id + " has been successfully deleted.");
    }

    // complete todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable Long id){
        TodoDto updated = todoService.completeTodo(id);
        return ResponseEntity.ok(updated);
    }

    // incomplete todo REST API
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable Long id){
        TodoDto updated = todoService.inCompleteTodo(id);
        return ResponseEntity.ok(updated);
    }


}

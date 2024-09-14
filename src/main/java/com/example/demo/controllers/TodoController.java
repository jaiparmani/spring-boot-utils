package com.example.demo.controllers;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.Todo.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/todo/")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("getAllTodos")
    public ResponseEntity<List<TodoEntity>> getAllTodos(){
        return todoService.getAllTodos();
    }
    @PostMapping("insertTodo")
    public ResponseEntity<TodoEntity> insertTodo(TodoEntity todoEntity){
        return todoService.insertTodo(todoEntity);
    }
}

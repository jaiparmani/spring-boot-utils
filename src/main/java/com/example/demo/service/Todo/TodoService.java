package com.example.demo.service.Todo;

import com.example.demo.entity.TodoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {
    public ResponseEntity<List<TodoEntity>> getAllTodos();
    public ResponseEntity<TodoEntity> insertTodo(TodoEntity todoEntity);
    public ResponseEntity deleteTodo(Long id) throws Exception;

    public ResponseEntity<TodoEntity> updateTodo(TodoEntity todoEntity);


    }

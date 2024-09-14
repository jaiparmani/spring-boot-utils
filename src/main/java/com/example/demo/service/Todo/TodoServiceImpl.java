package com.example.demo.service.Todo;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoJpaRepository todoJpaRepository;
    public TodoServiceImpl(TodoJpaRepository todoJpaRepository){
        this.todoJpaRepository = todoJpaRepository;
    }

    @Override
    public ResponseEntity<List<TodoEntity>> getAllTodos() {
        List<TodoEntity> todoEntityList = todoJpaRepository.findAll();
        return ResponseEntity.ok(todoEntityList);
    }
    @Override
    public ResponseEntity<TodoEntity> insertTodo(TodoEntity todoEntity){
        TodoEntity insertedTodoEntity = todoJpaRepository.save(todoEntity);
        return ResponseEntity.ok(insertedTodoEntity);
    }
}

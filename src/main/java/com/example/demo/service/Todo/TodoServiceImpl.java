package com.example.demo.service.Todo;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.common.Constants.DELETE_SUCCCESSFUL;

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
    @Override
    public ResponseEntity deleteTodo(Long id) throws Exception{
        Optional<TodoEntity> todoEntityToDelete = todoJpaRepository.findById(id);
        if(todoEntityToDelete.isEmpty())
            throw new Exception("Todo with id :: " + id + " not found.");
        todoJpaRepository.delete(todoEntityToDelete.get());
        return ResponseEntity.ok(DELETE_SUCCCESSFUL);
    }
}

package com.bootcamp.springboot.service;



import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllToDos(){
        return todoRepository.findAll();
    }

    public void saveToDo(Todo todo){
        todoRepository.save(todo);
    }
}



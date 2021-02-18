package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

//@Controller
@RestController
public class IndexController {

    private final TodoService todoService;

    public IndexController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value= "/todos", method = RequestMethod.GET,produces="application/json")
    public List<Todo> todoList() throws SQLException {
        return todoService.getAllToDos();
    }

    @RequestMapping(value= "/todos", method = RequestMethod.POST,produces="application/json")
    public ResponseEntity<Todo> saveTodos(@RequestBody Todo todo) throws SQLException {
        todoService.saveToDo(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }
}

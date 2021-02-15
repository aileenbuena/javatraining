package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Tasks;
import com.bootcamp.springboot.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

//@Controller
@RestController
public class IndexController {

    private final TaskService taskService;

    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value= "/tasks", method = RequestMethod.GET,produces="application/json")
    public List<Tasks> taskList() throws SQLException {

        return taskService.getAllTasks();
        //return "index";
    }
}

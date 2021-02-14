package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Tasks;
import com.bootcamp.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@Controller
//@RestController
public class IndexController {

    private final TaskService taskService;

    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String home(Model model) throws SQLException {
        String strReturn = taskService.Test1();
        model.addAttribute("test1", strReturn);
        return "index";
    }
}

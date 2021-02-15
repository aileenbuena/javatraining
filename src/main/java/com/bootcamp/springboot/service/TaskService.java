package com.bootcamp.springboot.service;


import com.bootcamp.springboot.model.Tasks;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface TaskService {

List<Tasks> getAllTasks() throws SQLException;

}



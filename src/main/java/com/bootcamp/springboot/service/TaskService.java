package com.bootcamp.springboot.service;

import com.bootcamp.springboot.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class TaskService {

    AppConfig config;

    @Autowired
    public TaskService(AppConfig config) {
        this.config = config;
    }

    public Connection getDBConnection() throws SQLException {
        System.out.print(config.getServerurl());
        return DriverManager.getConnection(config.getServerurl(),config.getUser(),config.getPassword());
    }

    public String Test1() throws SQLException {
        Connection con = getDBConnection();
        con.close();
        return "test1";
    }

}



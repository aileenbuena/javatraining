package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.config.AppConfig;
import com.bootcamp.springboot.model.Tasks;
import com.bootcamp.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository implements TaskService {

    AppConfig config;

    @Autowired
    public TaskRepository(AppConfig config) {
        this.config = config;
    }

    @Override
    public List<Tasks> getAllTasks() throws SQLException {
        List<Tasks> list = new ArrayList<Tasks>() {};
        Connection connection = getDBConnection();
        ResultSet rs;

        try
        {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM Task");
            while(rs.next()){
                Tasks task = new Tasks();
                task.setTaskID(rs.getInt("TaskID"));
                task.setTaskName(rs.getString("TaskName"));
                task.setEndDate(rs.getDate("EndDate"));
                task.setStatus(rs.getString("Status"));

                list.add(task);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally {
            connection.close();
        }
        return list;
    }

    public Connection getDBConnection() throws SQLException {
        System.out.print(config.getServerurl());
        return DriverManager.getConnection(config.getServerurl(),config.getUser(),config.getPassword());
    }

}

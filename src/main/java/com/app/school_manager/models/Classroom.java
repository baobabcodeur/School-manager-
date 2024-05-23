package com.app.school_manager.models;

import com.app.school_manager.dbconfig.IDBConfig;
import com.app.school_manager.interfaces.ClassroomInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Classroom implements ClassroomInterface {

    private int id ;

    private String name ;

    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Classroom> list() throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();

        connection = IDBConfig.getConnection();
        if (connection != null) {
            String req = "SELECT * FROM classroom";
            PreparedStatement prepareStatement =
                    this.connection.prepareStatement(req);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                Classroom classroom = new Classroom();
                classroom.setId(resultSet.getInt("id"));
                classroom.setName(resultSet.getString("name"));


                classrooms.add(classroom);
            }
            prepareStatement.close();
            this.connection.close();
        }
        return classrooms;
    }

    @Override
    public void create(Classroom classrooms) throws SQLException {

    }

    @Override
    public void update(Classroom classrooms) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}

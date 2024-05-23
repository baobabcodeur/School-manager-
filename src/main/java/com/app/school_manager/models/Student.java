package com.app.school_manager.models;

import com.app.school_manager.dbconfig.IDBConfig;
import com.app.school_manager.interfaces.StudentInterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student extends User implements StudentInterface {

    private int id;

    private String firstname ;

    private String lastname ;

    private Classroom classroom ;

    private String dateOfBirth ;

    private String placeOfBirth ;

    private String state ;

    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void create(Student students) throws SQLException {
        connection = IDBConfig.getConnection();
        if (connection != null) {

            String req = "{CALL createStudent(?, ?, ?, ?, ?, ?)}";

            CallableStatement callableStatement = connection.prepareCall(req);
            callableStatement.setString(1, students.getFirstname());
            callableStatement.setString(2, students.getLastname());
            callableStatement.setString(3, students.getDateOfBirth());
            callableStatement.setString(4, students.getPlaceOfBirth());
            callableStatement.setString(5, students.getState());
            callableStatement.setInt(6, students.getClassroom().getId());

            callableStatement.execute();
            callableStatement.close();
            this.connection.close();
        }
    }


    @Override
    public void update(Student students) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}

package com.app.school_manager.interfaces;

import com.app.school_manager.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    void create (Student students) throws SQLException;
    void update(Student students) throws SQLException;
    void delete(int id) throws SQLException;
}

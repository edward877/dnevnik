/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import java.sql.ResultSet;
import ModelDB.Teacher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

/**
 *
 * @author Admin
 */
public class TeacherDB {

    private ManageConnect mConnect;

    public TeacherDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(Teacher teacher) throws SQLException {
        Formatter f = new Formatter();
        f.format("insert into teacher values ( nextval('seq_teacher'), '%s', '%s', '%s');",
                teacher.getName(), teacher.getSurname(), teacher.getPatronymic());
        mConnect.executeUpdate(f.toString());
    }

    public void update(Teacher teacher) throws SQLException {
        Formatter f = new Formatter();
        f.format("update teacher set surname = '%s', name = '%s', patronymic = '%s' where  id_teacher =  %d;",
                teacher.getSurname(), teacher.getName(), teacher.getPatronymic(), teacher.getTeacherId());
        mConnect.executeUpdate(f.toString());
    }

    public void delete(Teacher teacher) throws SQLException {
        String query = "delete from teacher where id_teacher = " + teacher.getTeacherId();
        mConnect.executeUpdate(query);
    }

    public List<Teacher> all() throws SQLException {
        List<Teacher> teachers;
        teachers = new ArrayList<>();
        ResultSet rs = mConnect.executeQuery("select * from teacher");
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("id_teacher"));
            teacher.setSurname(rs.getString("surname"));
            teacher.setName(rs.getString("name"));
            teacher.setPatronymic(rs.getString("patronymic"));
            teachers.add(teacher);
        }
        return teachers;
    }

    public Teacher one(int id) throws SQLException {
        Teacher teacher = new Teacher();
        Formatter f = new Formatter();
        f.format("select * from teacher where id_teacher = '%d'", id);
        ResultSet rs = mConnect.executeQuery(f.toString());
        rs.next();
        teacher.setTeacherId(rs.getInt("id_teacher"));
        teacher.setSurname(rs.getString("surname"));
        teacher.setName(rs.getString("name"));
        teacher.setPatronymic(rs.getString("patronymic"));
        return teacher;
    }

}

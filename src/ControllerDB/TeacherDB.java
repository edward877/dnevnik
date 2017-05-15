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
        try {
            Formatter f = new Formatter();
            f.format("insert into teacher values ( nextval('seq_teacher'), '%s', '%s', '%s');",
                    teacher.getName(), teacher.getSurname(), teacher.getPatronymic());
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void update(Teacher teacher) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("update teacher set surname = '%s', name = '%s', patronymic = '%s' where  id_teacher =  %d;",
                    teacher.getSurname(), teacher.getName(), teacher.getPatronymic(), teacher.getId_teacher());

            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Teacher teacher) throws SQLException {
        try {
            String query = "delete from teacher where id_teacher = " + teacher.getId_teacher();
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    

    public List<Teacher> all() throws SQLException {
        List<Teacher> entities;
        
        try {
            entities = new ArrayList<>();

            ResultSet rs = mConnect.executeQuery("select * from teacher");
            while (rs.next()) {
                Teacher entity = new Teacher();
                entity.setId_teacher(rs.getInt("id_teacher"));
                entity.setSurname(rs.getString("surname"));
                entity.setName(rs.getString("name"));
                entity.setPatronymic(rs.getString("patronymic"));
                entities.add(entity);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }

    public Teacher one(int id) throws SQLException {
        Teacher one = new Teacher();
        try {
            Formatter f = new Formatter();
            f.format("select * from teacher where id_teacher = '%d'", id);
            ResultSet rs = mConnect.executeQuery(f.toString());
            
            rs.next();
            one.setId_teacher(rs.getInt("id_teacher"));
            one.setSurname(rs.getString("surname"));
            one.setName(rs.getString("name"));
            one.setPatronymic(rs.getString("patronymic"));
            
        } catch (Exception ex) {
            throw ex;
        }
        return one;
    }

}

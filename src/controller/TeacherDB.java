/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connection.ManageConnect;
import java.sql.ResultSet;
import model.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TeacherDB {
    
     private ManageConnect mConnect;
     
    public TeacherDB(ManageConnect mConnect){
        this.mConnect = mConnect;
    }

    
    public void add(Teacher entity) throws SQLException {
        try{
            String query = "insert into teachers surname,name, patronymic"
                + entity.getSurname() + "','"
                + entity.getName() + "','"
                + entity.getPatronymic() +  "');";
            mConnect.executeQuery(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    
     public List<Teacher> all() throws SQLException {
        List<Teacher> entities = null;
        try {
            entities = new ArrayList<>();
            System.out.println(mConnect);
            ResultSet rs = mConnect.executeQuery("select * from teacher");
            while(rs.next()){
                Teacher entity = new Teacher();
                entity.setId_teacher(rs.getInt("id_teacher"));
                entity.setSurname(rs.getString("surname"));
                entity.setName(rs.getString("name"));
                entity.setPatronymic(rs.getString("patronymic"));
                entities.add(entity);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return entities;
    }
}

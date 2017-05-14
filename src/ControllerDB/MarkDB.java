/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ModelDB.Mark;

/**
 *
 * @author Admin
 */
public class MarkDB {
     private ManageConnect mConnect;

    public MarkDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }
     
//       public void add(Teacher entity) throws SQLException {
//        try{
//            String query = "insert into (mark surname,name, patronymic) values "
//                + entity.getSurname() + "','"
//                + entity.getName() + "','"
//                + entity.getPatronymic() +  "');";
//            mConnect.executeQuery(query);
//        } catch (SQLException ex) {
//            throw ex;
//        }
//    }
//    
//     public void update(Teacher entity) throws SQLException {
//        try{
//            String query = "update into teachers surname,name, patronymic = '"  
//                + entity.getSurname() + "','"
//                + entity.getName() + "','"
//                + entity.getPatronymic() +  "');";
//            mConnect.executeQuery(query);
//        } catch (SQLException ex) {
//            throw ex;
//        }
//    }
//    
//     public void delete(Teacher entity) throws SQLException {
//        try{
//            String query = "delete from teachers where id_teacher = " + entity.getId_teacher();
//            mConnect.executeQuery(query);
//        } catch (SQLException ex) {
//            throw ex;
//        }
//    }
//    
     public List<Mark> all() {
        List<Mark> entities = null;
        try {
            entities = new ArrayList<>();
            ResultSet rs = mConnect.executeQuery("select * from mark");
            while(rs.next()){
                Mark entity = new Mark();
                entity.setId_mark(rs.getInt("id_teacher"));
                entity.setId_pupil(rs.getInt("id_pupil"));
                entity.setId_teacher(rs.getInt("id_teacher"));
                entity.setId_subject(rs.getInt("id_subject"));
                entity.setMark(rs.getInt("mark"));
                entity.setDate(rs.getDate("date"));
                entities.add(entity);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return entities;
    }
}

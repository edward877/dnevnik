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
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class MarkDB {

    private ManageConnect mConnect;

    public MarkDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(int id_pupil,int id_teacher, int id_subject, int mark, Date date) throws SQLException {
        try {
            String query = "insert into mark values ( nextval('seq_mark'),"
                    + id_pupil + ","
                    + id_teacher + ","
                    + id_subject + ","
                    + mark + ",'"
                    + date + "');";
            mConnect.executeUpdate(query);
            
        } catch (SQLException ex) {
            throw ex;
        }
    }

     public void update(int id_mark, int id_pupil,int id_teacher, int id_subject, int mark, Date date) throws SQLException {
        try{
            String query = "update mark set  id_pupil=" +  id_pupil 
                    + ",id_teacher =  " + id_teacher 
                   + ",id_subject =  " + id_subject 
                    + ",mark =  " + mark 
                    + ",date =  '" + date + "'"
                    + "where id_mark = " + id_mark;
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
     public void delete(int id_mark) throws SQLException {
        try{
            String query = "delete from mark where id_mark = " + id_mark;
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
      List<Mark> entities = null;
    public List<Mark> all() {
        try {
            entities = new ArrayList<>();
            ResultSet rs = mConnect.executeQuery("select * from mark");
            while (rs.next()) {
                Mark entity = new Mark();
                entity.setId_mark(rs.getInt("id_mark"));
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

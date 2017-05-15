/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import ModelDB.Homework;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HomeworkDB {
    private ManageConnect mConnect;

    public HomeworkDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(Homework homework) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("insert into homework values ( nextval('seq_homework'), '%d', '%d', '%d', '%s', '" + homework.getDate() + "');",
                    homework.getId_class(), homework.getId_teacher(),homework.getId_subject(), homework.getHomework() );
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void update(Homework homework) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("update homework set id_class = '%d',id_teacher = '%d',id_subject = '%d',name = '%s',  date = '" 
                    + homework.getDate()+"' where  id_teacher =  %d;",
                    homework.getId_class(), homework.getId_teacher(),homework.getId_subject(), homework.getHomework(), homework.getId_homework() );

            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Homework homework) throws SQLException {
        try {
            String query = "delete from homework where id_teacher = " + homework.getId_homework();
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    

    public List<Homework> all() throws SQLException {
        List<Homework> entities;
        
        try {
            entities = new ArrayList<>();

            ResultSet rs = mConnect.executeQuery("select * from homework");
            while (rs.next()) {
                Homework entity = new Homework();
                entity.setId_homework(rs.getInt("id_homework"));
                entity.setId_class(rs.getInt("id_class"));
                entity.setId_teacher(rs.getInt("id_teacher"));
                entity.setId_subject(rs.getInt("id_subject"));
                entity.setHomework(rs.getString("name"));
                entity.setDate(rs.getDate("date"));
                entities.add(entity);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }
}

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
import java.util.Formatter;

/**
 *
 * @author Admin
 */
public class MarkDB {

    private ManageConnect mConnect;

    public MarkDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(Mark mark) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("insert into mark values ( nextval('seq_mark'), %d, %d, %d, %d, '"+mark.getDate() + "')" ,
                    mark.getId_pupil(), mark.getId_teacher(), mark.getId_subject(),mark.getMark(),mark.getDate());
            
            mConnect.executeUpdate(f.toString());

        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void update(Mark mark) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("update mark set  id_pupil = %d,id_teacher = %d, id_subject = %d, mark = %d, date = '" + mark.getDate()+"'  where id_mark = %d;",
                    mark.getId_pupil(), mark.getId_teacher(), mark.getId_subject(),mark.getMark(), mark.getId_mark());
            
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Mark mark) throws SQLException {
        try {
            String query = "delete from mark where id_mark = " + mark.getId_mark();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import ModelDB.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SubjectDB {

    private ManageConnect mConnect;

    public SubjectDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(Subject subject) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("insert into subject values ( nextval('seq_subject'), '%s');",
                    subject.getName());
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void update(Subject subject) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("update subject set name = '%s' where  id_subject =  %d;",
                    subject.getName(), subject.getId_subject());

            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Subject subject) throws SQLException {
        try {
            String query = "delete from subject where id_subject = " + subject.getId_subject();
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    List<Subject> entities = null;

    public List<Subject> all() throws SQLException {
        try {
            entities = new ArrayList<>();

            ResultSet rs = mConnect.executeQuery("select * from subject");
            while (rs.next()) {
                Subject entity = new Subject();
                entity.setId_subject(rs.getInt("id_subject"));
                entity.setName(rs.getString("name"));
                entities.add(entity);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }

    public Subject one(int id) throws SQLException {
        Subject one = new Subject();
        try {
            Formatter f = new Formatter();
            f.format("select * from subject where id_subject = '%d'", id);
            ResultSet rs = mConnect.executeQuery(f.toString());

            rs.next();
            one.setId_subject(rs.getInt("id_subject"));
            one.setName(rs.getString("name"));

        } catch (Exception ex) {
            throw ex;
        }
        return one;
    }
}

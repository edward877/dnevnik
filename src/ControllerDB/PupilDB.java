/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import ModelDB.Pupil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PupilDB {

    private ManageConnect mConnect;

    public PupilDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(Pupil pupil) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("insert into pupil values ( nextval('seq_pupil'), '%d', '%s', '%s', '%s');",
                    pupil.getId_class(), pupil.getName(), pupil.getSurname(), pupil.getPatronymic());
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void update(Pupil pupil) throws SQLException {
        try {
            Formatter f = new Formatter();
            f.format("update pupil set id_class = '%d',  name = '%s', surname = '%s', patronymic = '%s' where  id_pupil =  %d;",
                     pupil.getId_class(), pupil.getName(), pupil.getSurname(), pupil.getPatronymic(), pupil.getId_pupil());

            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void delete(Pupil pupil) throws SQLException {
        try {
            String query = "delete from pupil where id_pupil = " + pupil.getId_pupil();
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    List<Pupil> entities = null;

    public List<Pupil> all() throws SQLException {
        try {
            entities = new ArrayList<>();

            ResultSet rs = mConnect.executeQuery("select * from pupil");
            while (rs.next()) {
                Pupil entity = new Pupil();
                entity.setId_pupil(rs.getInt("id_pupil"));
                entity.setId_class(rs.getInt("id_class"));
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

    public Pupil one(int id) throws SQLException {
        Pupil one = new Pupil();
        try {
            Formatter f = new Formatter();
            f.format("select * from pupil where id_pupil = '%d'", id);
            ResultSet rs = mConnect.executeQuery(f.toString());

            rs.next();
            one.setId_pupil(rs.getInt("id_pupil"));
            one.setId_class(rs.getInt("id_class"));
            one.setSurname(rs.getString("surname"));
            one.setName(rs.getString("name"));
            one.setPatronymic(rs.getString("patronymic"));

        } catch (Exception ex) {
            throw ex;
        }
        return one;
    }
}

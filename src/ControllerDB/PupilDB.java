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
            Formatter f = new Formatter();
            f.format("insert into pupil values ( nextval('seq_pupil'), '%d', '%s', '%s', '%s');",
                    pupil.getId_class(), pupil.getName(), pupil.getSurname(), pupil.getPatronymic());
            mConnect.executeUpdate(f.toString());
    }

    public void update(Pupil pupil) throws SQLException {
            Formatter f = new Formatter();
            f.format("update pupil set id_class = '%d',  name = '%s', surname = '%s', patronymic = '%s' where  id_pupil =  %d;",
                     pupil.getId_class(), pupil.getName(), pupil.getSurname(), pupil.getPatronymic(), pupil.getId_pupil());
            mConnect.executeUpdate(f.toString());
    }

    public void delete(Pupil pupil) throws SQLException {
            String query = "delete from pupil where id_pupil = " + pupil.getId_pupil();
            mConnect.executeUpdate(query);
    }

    public List<Pupil> all() throws SQLException {
           List<Pupil> pupils = new ArrayList<>();
            ResultSet rs = mConnect.executeQuery("select * from pupil");
            while (rs.next()) {
                Pupil pupil = new Pupil();
                pupil.setId_pupil(rs.getInt("id_pupil"));
                pupil.setId_class(rs.getInt("id_class"));
                pupil.setSurname(rs.getString("surname"));
                pupil.setName(rs.getString("name"));
                pupil.setPatronymic(rs.getString("patronymic"));
                pupils.add(pupil);
            }
        return pupils;
    }

    public Pupil one(int id) throws SQLException {
        Pupil pupil = new Pupil();
            Formatter f = new Formatter();
            f.format("select * from pupil where id_pupil = '%d'", id);
            ResultSet rs = mConnect.executeQuery(f.toString());
            rs.next();
            pupil.setId_pupil(rs.getInt("id_pupil"));
            pupil.setId_class(rs.getInt("id_class"));
            pupil.setSurname(rs.getString("surname"));
            pupil.setName(rs.getString("name"));
            pupil.setPatronymic(rs.getString("patronymic"));
        return pupil;
    }
}

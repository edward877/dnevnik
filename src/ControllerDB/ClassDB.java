/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import ModelDB.School_Class;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClassDB {

    private ManageConnect mConnect;

    public ClassDB(ManageConnect mConnect) {
        this.mConnect = mConnect;
    }

    public void add(School_Class clas) throws SQLException {
        Formatter f = new Formatter();
        f.format("insert into class values ( nextval('seq_class'), '%s');", clas.getName());
        mConnect.executeUpdate(f.toString());
    }

    public void update(School_Class clas) throws SQLException {
        Formatter f = new Formatter();
        f.format("update class set name = '%s' where  id_class =  %d;",
                clas.getName(), clas.getClassId());
        mConnect.executeUpdate(f.toString());
    }

    public void delete(School_Class clas) throws SQLException {
        String query = "delete from class where id_class = " + clas.getClassId();
        mConnect.executeUpdate(query);
    }

    public List<School_Class> all() throws SQLException {
        List<School_Class> classes;
        classes = new ArrayList<>();

        ResultSet rs = mConnect.executeQuery("select * from class");
        while (rs.next()) {
            School_Class school_class = new School_Class();
            school_class.setClassId(rs.getInt("id_class"));
            school_class.setName(rs.getString("name"));
            classes.add(school_class);
        }
        return classes;
    }

    public School_Class one(int id) throws SQLException {
        School_Class school_class = new School_Class();
        Formatter f = new Formatter();
        f.format("select * from class where id_class = '%d'", id);
        ResultSet rs = mConnect.executeQuery(f.toString());
        rs.next();
        school_class.setClassId(rs.getInt("id_class"));
        school_class.setName(rs.getString("name"));
        return school_class;
    }
}

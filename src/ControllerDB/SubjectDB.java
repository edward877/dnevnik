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
        Formatter f = new Formatter();
        f.format("insert into subject values ( nextval('seq_subject'), '%s');",
                subject.getName());
        mConnect.executeUpdate(f.toString());
    }

    public void update(Subject subject) throws SQLException {
        Formatter f = new Formatter();
        f.format("update subject set name = '%s' where  id_subject =  %d;",
                subject.getName(), subject.getSubjectId());
        mConnect.executeUpdate(f.toString());
    }

    public void delete(Subject subject) throws SQLException {
        String query = "delete from subject where id_subject = " + subject.getSubjectId();
        mConnect.executeUpdate(query);
    }

    public List<Subject> all() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        ResultSet rs = mConnect.executeQuery("select * from subject");
        while (rs.next()) {
            Subject subject = new Subject();
            subject.setSubjectId(rs.getInt("id_subject"));
            subject.setName(rs.getString("name"));
            subjects.add(subject);
        }
        return subjects;
    }

    public Subject one(int id) throws SQLException {
        Subject subject = new Subject();
        Formatter f = new Formatter();
        f.format("select * from subject where id_subject = '%d'", id);
        ResultSet rs = mConnect.executeQuery(f.toString());

        rs.next();
        subject.setSubjectId(rs.getInt("id_subject"));
        subject.setName(rs.getString("name"));
        return subject;
    }
}

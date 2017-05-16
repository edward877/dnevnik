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
        Formatter f = new Formatter();
        f.format("insert into homework values ( nextval('seq_homework'), '%d', '%d', '%d', '%s', '" + homework.getDate() + "');",
                homework.getClassId(), homework.getTeacherId(), homework.getSubjectId(), homework.getHomework());
        mConnect.executeUpdate(f.toString());
    }

    public void update(Homework homework) throws SQLException {
        Formatter f = new Formatter();
        f.format("update homework set id_class = '%d',id_teacher = '%d',id_subject = '%d',name = '%s',  date = '"
                + homework.getDate() + "' where  id_teacher =  %d;",
                homework.getClassId(), homework.getTeacherId(), homework.getSubjectId(), homework.getHomework(), homework.getHomeworkId());

        mConnect.executeUpdate(f.toString());
    }

    public void delete(Homework homework) throws SQLException {
        String query = "delete from homework where id_teacher = " + homework.getHomeworkId();
        mConnect.executeUpdate(query);
    }

    public List<Homework> all() throws SQLException {
        List<Homework> homeworks = new ArrayList<>();
        ResultSet rs = mConnect.executeQuery("select * from homework");
        while (rs.next()) {
            Homework homework = new Homework();
            homework.setHomeworkId(rs.getInt("id_homework"));
            homework.setClassId(rs.getInt("id_class"));
            homework.setTeacherId(rs.getInt("id_teacher"));
            homework.setSubjectId(rs.getInt("id_subject"));
            homework.setHomework(rs.getString("name"));
            homework.setDate(rs.getDate("date"));
            homeworks.add(homework);
        }
        return homeworks;
    }
}

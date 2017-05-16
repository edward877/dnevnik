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
        Formatter f = new Formatter();
        f.format("insert into mark values ( nextval('seq_mark'), %d, %d, %d, %d, '" + mark.getDate() + "')",
                mark.getPupilId(), mark.getTeacherId(), mark.getSubjectId(), mark.getMark(), mark.getDate());
        mConnect.executeUpdate(f.toString());
    }

    public void update(Mark mark) throws SQLException {
        Formatter f = new Formatter();
        f.format("update mark set  id_pupil = %d,id_teacher = %d, id_subject = %d, mark = %d, date = '" + mark.getDate() + "'  where id_mark = %d;",
                mark.getPupilId(), mark.getTeacherId(), mark.getSubjectId(), mark.getMark(), mark.getMarkId());
        mConnect.executeUpdate(f.toString());
    }

    public void delete(Mark mark) throws SQLException {
        String query = "delete from mark where id_mark = " + mark.getMarkId();
        mConnect.executeUpdate(query);
    }

    public List<Mark> all() throws SQLException {
        List<Mark> marks = new ArrayList<>();
        ResultSet rs = mConnect.executeQuery("select * from mark");
        while (rs.next()) {
            Mark entity = new Mark();
            entity.setMarkId(rs.getInt("id_mark"));
            entity.setPupilId(rs.getInt("id_pupil"));
            entity.setTeacherId(rs.getInt("id_teacher"));
            entity.setSubjectId(rs.getInt("id_subject"));
            entity.setMark(rs.getInt("mark"));
            entity.setDate(rs.getDate("date"));
            marks.add(entity);
        }

        return marks;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDB;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Mark {

    private int markId;
    private int pupilId;
    private int teacherId;
    private int subjectId;
    private int mark;
    private Date date;

    public Mark(int id_pupil, int id_teacher, int id_subject, int mark, Date date) {
        this.pupilId = id_pupil;
        this.teacherId = id_teacher;
        this.subjectId = id_subject;
        this.mark = mark;
        this.date = date;
    }

    public Mark() {
    }

    public int getMarkId() {
        return markId;
    }

    public int getPupilId() {
        return pupilId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getMark() {
        return mark;
    }

    public Date getDate() {
        return date;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}

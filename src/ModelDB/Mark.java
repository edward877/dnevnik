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

    int id_mark;
    private int id_pupil;
    private int id_teacher;
    private int id_subject;
    private int mark;
    private Date date;

    public Mark(int id_pupil, int id_teacher, int id_subject, int mark, Date date) {
        this.id_pupil = id_pupil;
        this.id_teacher = id_teacher;
        this.id_subject = id_subject;
        this.mark = mark;
        this.date = date;
    }

    public Mark() {}

    public int getId_mark() {
        return id_mark;
    }

    public int getId_pupil() {
        return id_pupil;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public int getId_subject() {
        return id_subject;
    }

    public int getMark() {
        return mark;
    }

    public Date getDate() {
        return date;
    }

    public void setId_mark(int id_mark) {
        this.id_mark = id_mark;
    }

    public void setId_pupil(int id_pupil) {
        this.id_pupil = id_pupil;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}

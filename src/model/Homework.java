/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Homework {
    
    private int id_homework;
    private int id_class;
    private int id_teacher;
    private int id_subject;
    private String homework;
    private Date date;

    public Homework(int id_homework, int id_class, int id_teacher, int id_subject, String homework, Date date) {
        this.id_homework = id_homework;
        this.id_class = id_class;
        this.id_teacher = id_teacher;
        this.id_subject = id_subject;
        this.homework = homework;
        this.date = date;
    }

    public int getId_homework() {
        return id_homework;
    }

    public int getId_class() {
        return id_class;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public int getId_subject() {
        return id_subject;
    }

    public String getHomework() {
        return homework;
    }

    public Date getDate() {
        return date;
    }

    public void setId_homework(int id_homework) {
        this.id_homework = id_homework;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}

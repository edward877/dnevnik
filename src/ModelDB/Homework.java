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
public class Homework {
    
    private int homeworkId;
    private int classId;
    private int teacherId;
    private int subjectId;
    private String homework;
    private Date date;

    public Homework(int id_class, int id_teacher, int id_subject, String homework, Date date) {
        this.classId = id_class;
        this.teacherId = id_teacher;
        this.subjectId = id_subject;
        this.homework = homework;
        this.date = date;
    }

    public Homework() {
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public int getClassId() {
        return classId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getHomework() {
        return homework;
    }

    public Date getDate() {
        return date;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}

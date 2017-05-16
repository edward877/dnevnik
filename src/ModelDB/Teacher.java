/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDB;

/**
 *
 * @author Admin
 */
public class Teacher {
    private int teacherId;
    private String name;
    private String surname;
    private String patronymic;
    
    public Teacher(){}

    public Teacher(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    
    public int getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    @Override
    public String toString(){
        return name + " " + surname + " " + patronymic;
    } 
}

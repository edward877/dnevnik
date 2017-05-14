/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Pupil {
    private int id_pupil;
    private int id_class;
    private String name;
    private String surname;
    private String patronymic;

    public Pupil(int id_pupil, int id_class, String name, String surname, String patronymic) {
        this.id_pupil = id_pupil;
        this.id_class = id_class;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public int getId_pupil() {
        return id_pupil;
    }

    public int getId_class() {
        return id_class;
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

    public void setId_pupil(int id_pupil) {
        this.id_pupil = id_pupil;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
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
    
    
    
    
}

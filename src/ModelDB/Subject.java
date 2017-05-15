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
public class Subject {
    private int id_subject;
    private String name;

    public Subject( String name) {
        this.name = name;
    }

    public Subject() {
    }

    public int getId_subject() {
        return id_subject;
    }

    public String getName() {
        return name;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @Override
    public String toString(){
        return  name;
    } 
}

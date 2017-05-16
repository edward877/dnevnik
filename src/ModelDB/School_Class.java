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

public class School_Class {
    private int classId;
    private String name;

    public School_Class(String name) {
        this.name = name;
    }

    public School_Class() {
    }

    public int getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @Override
    public String toString(){
        return name;
    } 
}

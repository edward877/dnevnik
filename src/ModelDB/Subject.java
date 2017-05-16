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
    private int subjectId;
    private String name;

    public Subject( String name) {
        this.name = name;
    }

    public Subject() {
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     @Override
    public String toString(){
        return  name;
    } 
}

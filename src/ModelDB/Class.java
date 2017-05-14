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

public class Class {
    private int id_class;
    private String name;

    public Class(int id_class, String name) {
        this.id_class = id_class;
        this.name = name;
    }

    public int getId_class() {
        return id_class;
    }

    public String getName() {
        return name;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

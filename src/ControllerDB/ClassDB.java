/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDB;

import Connection.ManageConnect;
import ModelDB.Clas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClassDB {
     private ManageConnect mConnect;
     
    public ClassDB(ManageConnect mConnect){
        this.mConnect = mConnect;
    }

    
    public void add(Clas clas) throws SQLException {
        try{
            Formatter f = new Formatter();
            f.format("insert into class values ( nextval('seq_class'), '%s');", clas.getName());
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
     public void update(Clas clas) throws SQLException {
        try{
            Formatter f = new Formatter();
            f.format("update class set name = '%s' where  id_class =  %d;",
                     clas.getName(), clas.getId_class());
            
            mConnect.executeUpdate(f.toString());
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
     public void delete(Clas clas) throws SQLException {
        try{
            String query = "delete from class where id_class = " + clas.getId_class();
            mConnect.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        }
    }
     
     List<Clas> entities = null;
     public List<Clas> all() throws SQLException {
        try {
            entities = new ArrayList<>();
         
            ResultSet rs = mConnect.executeQuery("select * from class");
            while(rs.next()){
                Clas entity = new Clas();
                entity.setId_class(rs.getInt("id_class"));
                entity.setName(rs.getString("name"));
                entities.add(entity);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return entities;
    }
     
      public Clas one(int id) throws SQLException {
        Clas one = new Clas();
        try {
            Formatter f = new Formatter();
            f.format("select * from class where id_class = '%d'", id);
            ResultSet rs = mConnect.executeQuery(f.toString());
            
            rs.next();
            one.setId_class(rs.getInt("id_class"));
            one.setName(rs.getString("name"));
            
        } catch (Exception ex) {
            throw ex;
        }
        return one;
    }
}

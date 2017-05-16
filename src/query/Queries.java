/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.ManageConnect;


public class Queries {
    ManageConnect mcon;

    public Queries() {
    }

    public Queries(ManageConnect mcon) {
        this.mcon = mcon;
    }

    public List<Zapros1> queryFirst() throws SQLException{
        List<Zapros1> list;
        try {
            list = new ArrayList<>();
            String query = "Select c.name,  p.surname  " +
                    "From class c join pupil p " +
                    "On c.id_class = p.id_class " +
                    "Where c.id_class = 1;";
            ResultSet rs = mcon.executeQuery(query);
            while(rs.next()){
                Zapros1 z = new Zapros1();
                z.setClassName(rs.getString("name"));
                z.setSurname(rs.getString("surname"));
                list.add(z);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
        return list;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ManageConnect {

    private Connect con;   
    private Connection connection;
    private Statement statement;
    
    public ManageConnect(Connect con) {
       this.con = con;
    }
    
    public boolean openConnect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(con.getUrl(), con.getLogin(), con.getPassword());
            statement = connection.createStatement();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean closeConnection(){
        if (connection != null) {
                try {
                    connection.close(); // Каскадное закрытие statement, resultSet
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }
            }
        return true;
    }
    
    public ResultSet executeQuery(String query) throws SQLException{
        if(statement != null){
            try {
                return statement.executeQuery(query);
            } catch (SQLException ex) {
               throw ex;
            }   
        }
        return null;

    }
    
    
}

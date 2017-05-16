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

    public boolean openConnect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(con.getUrl(), con.getLogin(), con.getPassword());
        statement = connection.createStatement();
        return true;

    }

    public boolean closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            return true;
        }
        return false;

    }

    public ResultSet executeQuery(String query) throws SQLException {
        if (statement != null) {
                return statement.executeQuery(query);
        }
        return null;

    }

    public int executeUpdate(String query) throws SQLException {
        if (statement != null) {
            return statement.executeUpdate(query);
        }
        return 0;
    }

}

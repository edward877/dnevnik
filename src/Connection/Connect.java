/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author Admin
 */


public class Connect {
    
    private String url;
    private String login;
    private String password;
    
    public Connect(){}
    
    public Connect(String host, String port, String name, String login,String password ){
        this.url = "jdbc:postgresql://" + host +":"+ port +"/" + name;
        this.login = login;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
    
   
}

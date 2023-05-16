/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mes documants
 */
public class DBconnect {
     public  Connection ConnectBd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            
            String url = "jdbc:mysql://localhost:3306/uno_bibliotheque";
            String user = "root";
            String password = "";
            
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Succed");
            return connection;
    } catch (Exception e) {
        System.out.println("Connection Failed");
	System.out.println(e);
        return null;
    }
        
    }

 
        
    
    
}

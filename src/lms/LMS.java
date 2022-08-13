/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Santanu
 */
public class LMS {

    /**
     * @param args the command line arguments
     */
    
    static Connection con = null;
    
    
    
    public static Connection getConnection() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useTimezone=true&serverTimezone=UTC","root","");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author fatma
 */
public class JConnection {
    public Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");  
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\fatma\\Desktop\\JAVAProject\\Patients.db");  
           JOptionPane.showMessageDialog(null, "database is connected", "sdad", 3);
 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 3);
        }
        return conn;
    }
}

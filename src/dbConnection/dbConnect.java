/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ashutosh
 */
public class dbConnect {
    
    
    public static boolean check(){
        
        String url = "jdbc:mysql://u1rsa6azyxxatflf:yvSIzIqJpdQZBSaPNd4B@bcu09cy1pnibuq33wicz-mysql.services.clever-cloud.com:3306/bcu09cy1pnibuq33wicz";
        String username = "u1rsa6azyxxatflf";
        String password = "yvSIzIqJpdQZBSaPNd4B";
        
        
        try{
            
        Connection myConn = DriverManager.getConnection(url, username, password);
        
        myConn.close();
        return true;
        
         
         
        }catch(Exception exc){
            
            exc.printStackTrace();
            
            
        }
    
    return false;
    
 }
    
}

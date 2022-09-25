/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insuranceCompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ashutosh
 */
public class dbLoad {
    
    
        static String url = "jdbc:mysql://u1rsa6azyxxatflf:yvSIzIqJpdQZBSaPNd4B@bcu09cy1pnibuq33wicz-mysql.services.clever-cloud.com:3306/bcu09cy1pnibuq33wicz";
        static String username = "u1rsa6azyxxatflf";
        static String password = "yvSIzIqJpdQZBSaPNd4B";
        
        static Connection conn;
        static Statement myStmt;
     
    
        public static ArrayList<User> dbUserLoad(){

      
        
        
        ArrayList<User> users = new ArrayList<>();
        
       
        try{
       
        conn = DriverManager.getConnection(url, username, password);
        
        //Create Statement
        
        myStmt = conn.createStatement();
        
        
        //Exec Query
        
        ResultSet myRs = myStmt.executeQuery("SELECT * FROM USERS");
        
        
        //Print
        
         while(myRs.next()){
         
         int id = Integer.parseInt(myRs.getString("id"));
         String name = myRs.getString("name");    
         String pass = myRs.getString("password");
         users.add(new User(id,name,pass));
         
         
         
         }
         
         conn.close();
         return users;
        
        }catch(Exception exc){
            
            exc.printStackTrace();
        }

        return null;
    }
        
    public static boolean addUser(String name, String password){
        
        try{
            
        conn = DriverManager.getConnection(url, username, password);
        
        //Create Statement
        
        myStmt = conn.createStatement();
        
         //Exec Query
         //INSERT INTO `USERS` (`id`, `name`, `password`, `company`, `address`) VALUES (NULL, 'HelloKing', 'hehe', '1', '1');
       
       
        return true;
        }catch(Exception exc){
            
            exc.printStackTrace();
        }

        return false;
    }    
    
}

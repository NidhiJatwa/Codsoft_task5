
package codsoft_task5;


import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;


public class Conn {
    
    Connection c;           
    Statement s;
    Conn()
    {
       // String url;
       // String password = "*N@tw@*";
       // String username = "root";
        
      String url = "jdbc:mysql://localhost:3306/universitymanagementsystem";
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        
        
       
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//1. Regsiter the driver class
     //  c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","*N@tw@*");//2.
      c = DriverManager.getConnection(url, username, password);
     
       System.out.println(c);
       
       s=c.createStatement();
       
        } //catch(ClassNotFoundException e)
       // {
           //  Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, e);
           // e.printStackTrace();
       // } catch (SQLException e) {
        //    Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, e);
       // }
        
     catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection error.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error.");
            e.printStackTrace();   
        }
    }
    
    
    public static void main(String[] args) 
    {
        new Conn();// Create an instance of Conn which will execute the constructor
    }

   PreparedStatement prepareStatement(String query) {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
} 

     
    
    


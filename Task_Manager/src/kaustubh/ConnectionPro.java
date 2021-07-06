package kaustubh;

import java.sql.*;


public class ConnectionPro {
    public Connection con;
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project","root","");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(con);
        return con;
    }
}

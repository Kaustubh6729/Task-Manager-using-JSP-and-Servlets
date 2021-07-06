package kaustubh;

import java.sql.*;

public class UserDatabase {
    Connection con ;

    public UserDatabase() {
        
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(name,email,password) values(?,?,?)";
           ConnectionPro c = new ConnectionPro();
           PreparedStatement pt = c.getConnection().prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPassword());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
  //user login
    public User login(String email, String pass){
        User usr=null;
        try{
            String query ="select * from user where email=? and password=?";
            ConnectionPro c = new ConnectionPro();
            PreparedStatement pst = c.getConnection().prepareStatement(query);
       
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setName(rs.getString("name"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }

}
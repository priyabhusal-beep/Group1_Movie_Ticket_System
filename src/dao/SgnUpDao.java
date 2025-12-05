/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.demo.MySqlConnection;

import java.sql.*;
import model.UserData;

/**
 *
 * @author DELL
 */
public class SgnUpDao {
    MySqlConnection mysql = new MySqlConnection();
        
    public void signUp(UserData user){      
        Connection conn = mysql.openConnection();
        String sql = "Insert into users(mobileNumber,email,fullName,password) Values (?,?,?,?)";        
        try
            (PreparedStatement pstm = conn.prepareStatement(sql)){            
            pstm.setString(1, user.getMobileNumber());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getFullName());
            pstm.setString(4, user.getPassword());
            
          
           pstm.executeUpdate();            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            mysql.closeConnection(conn);
        }              
    }
    
        public boolean checkUser(UserData user){        
        Connection conn = mysql.openConnection();
        String sql = "Select * from users where mobileNumber=? or email=?";
        
        try(PreparedStatement pstm = conn.prepareStatement(sql)){            
            pstm.setString(1, user.getMobileNumber());
            pstm.setString(2, user.getEmail());
            ResultSet result = pstm.executeQuery();
            return result.next();
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;   
        }
}

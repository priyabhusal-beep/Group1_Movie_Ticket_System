/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import database.MySqlConnection;
import model.UserData;
/**
 *
 * @author HP
 */
public class LoginDao {
    MySqlConnection mysql = new MySqlConnection();
    
    public boolean login(UserData user) {
        Connection conn = mysql.openConnection();
        if (conn == null){
            System.out.println("LoginDao: Failed to open DB connection");
            return false;
        }
        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());

            ResultSet result = pstm.executeQuery();
            return result.next();  

        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}

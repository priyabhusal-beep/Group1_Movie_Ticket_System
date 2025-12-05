/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.MySqlConnection;
import model.ResetUser;
import java.sql.*;

/**
 *
 * @author salaj
 */
public class ResetPasswordDao {
    MySqlConnection mysql = new MySqlConnection();

    public boolean updatePassword(ResetUser user) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE users SET password = ? WHERE username = ? OR email = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getNewPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getEmail());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}

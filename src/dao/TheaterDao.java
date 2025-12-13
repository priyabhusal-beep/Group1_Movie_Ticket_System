/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author suman
 */
import database.MySqlConnection;
import model.Theater;
import java.sql.*;
import java.util.*;

public class TheaterDao {
    
    MySqlConnection mysql = new MySqlConnection();

    // Get all theaters from the database
    public List<Theater> getAllTheaters() {
        List<Theater> theaters = new ArrayList<>();
        String query = "SELECT * FROM theaters";

        try (Connection conn = mysql.openConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                theaters.add(new Theater(
                        rs.getInt("theater_id"),
                        rs.getString("name"),
                        rs.getString("location")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return theaters;
    }

    // Test main method
    public static void main(String[] args) {
        TheaterDao dao = new TheaterDao();
        List<Theater> theaters = dao.getAllTheaters();

        if (theaters.isEmpty()) {
            System.out.println("No theaters found.");
        } else {
            for (Theater t : theaters) {
                System.out.println("ID: " + t.getTheaterId() +
                                   ", Name: " + t.getName() +
                                   ", Location: " + t.getLocation());
            }
        }
    }
}

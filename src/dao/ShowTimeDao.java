/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author suman
 */
import database.MySQLConnection;
import model.ShowTime;
import java.sql.*;
import java.util.*;

public class ShowTimeDao {

    MySqlConnection mysql = new MySqlConnection();
    
   
    public List<ShowTime> getAllShowTimes() {
        List<ShowTime> showTimes = new ArrayList<>();
        String query = "SELECT * FROM showtimes";  

        try (Connection conn = mysql.openConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                showTimes.add(new ShowTime(
                        rs.getInt("showtime_id"),
                        rs.getInt("theater_id"),
                        rs.getString("movie_name"),
                        rs.getString("time")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching showtimes:");
            e.printStackTrace();
        }

        return showTimes;
    }

    
    public static void main(String[] args) {
        ShowTimeDao dao = new ShowTimeDao();
        List<ShowTime> showTimes = dao.getAllShowTimes();

        if (showTimes.isEmpty()) {
            System.out.println("No showtimes found.");
        } else {
            System.out.println("Showtimes in the database:");
            for (ShowTime s : showTimes) {
                System.out.println("ID: " + s.getShowtimeId() +
                                   ", Theater ID: " + s.getTheaterId() +
                                   ", Movie: " + s.getMovieName() +
                                   ", Time: " + s.getTime());
            }
        }
    }
}




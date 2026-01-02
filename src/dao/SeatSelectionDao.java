/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.SeatStatus;

/**
 * 
 * @author DELL
 */
public class SeatSelectionDao {

    private final MySqlConnection mysql = new MySqlConnection();

    // =====================================================
    // 1️⃣ GET SEAT STATUS (AVAILABLE / SOLD)
    // =====================================================
    public String getSeatStatus(int showId, String seatNo) {

        Connection conn = mysql.openConnection();
        String sql = "SELECT seat_status FROM seats WHERE show_id=? AND seat_number=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, showId);
            ps.setString(2, seatNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("seat_status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        // Default: seat not found → AVAILABLE
        return SeatStatus.AVAILABLE.name();
    }

    // =====================================================
    // 2️⃣ CHECK IF SEAT IS AVAILABLE
    // =====================================================
    public boolean isSeatAvailable(int showId, String seatNo) {
        return SeatStatus.AVAILABLE
                .name()
                .equalsIgnoreCase(getSeatStatus(showId, seatNo));
    }

    // =====================================================
    // 3️⃣ MARK SEAT AS SOLD (THIS FIXES COLOR ISSUE)
    // =====================================================
    public void markSeatSold(int showId, String seatNo) {

        Connection conn = mysql.openConnection();

        String sql = """
            UPDATE seats
            SET seat_status = ?
            WHERE show_id = ? AND seat_number = ?
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, SeatStatus.SOLD.name());
            ps.setInt(2, showId);
            ps.setString(3, seatNo);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
    }
}


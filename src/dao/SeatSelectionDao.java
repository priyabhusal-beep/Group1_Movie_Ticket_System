/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.MySqlConnection;
import java.sql.*;
import model.SeatData;
import database.Database;
import model.SeatStatus;

/**
 *
 * @author DELL
 */


public class SeatSelectionDao {

   MySqlConnection mysql = new MySqlConnection();

    // Insert or update seat
    public void saveSeat(int showId, SeatData seat) {

        Connection conn = mysql.openConnection();
        if (conn == null) {
            System.out.println("SeatDao: Failed to open DB connection");
            return;
        }

        String sql =
            "INSERT INTO seats ( seat_number, seat_status, price) " +
            "VALUES (?, ?, ?) " +
            "ON DUPLICATE KEY UPDATE seat_status=?, price=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, seat.getSeatNumber());
            pstm.setString(2, seat.getStatus().toString());   // enum → String
            pstm.setInt(3, seat.getSeatPrice());

            // parameters for UPDATE part
            pstm.setString(4, seat.getStatus().toString());
            pstm.setInt(5, seat.getSeatPrice());

                pstm.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        }
        finally {
                mysql.closeConnection(conn);
        }
    }

    // Check if seat is available
    public boolean isSeatAvailable(int showId, String seatNumber) {

        Connection conn = mysql.openConnection();
        if (conn == null) {
            System.out.println("SeatDao: Failed to open DB connection");
            return false;
        }

        String sql =
            "SELECT seat_status FROM seats WHERE show_id=? AND seat_number=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, showId);
            pstm.setString(2, seatNumber);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String status = rs.getString("seat_status");
                return status.equalsIgnoreCase(SeatStatus.AVAILABLE.name());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        return true; // seat not found → available
    }
    
    public String getSeatStatus(int showId, String seatNo) {

        Connection conn = mysql.openConnection();
        if (conn == null) {
            System.out.println("SeatDao: Failed to open DB connection");
            return SeatStatus.UNAVAILABLE.name();
    }

        String sql = "SELECT seat_status FROM seats WHERE show_id=? AND seat_number=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, showId);
            pstm.setString(2, seatNo);

            ResultSet rs = pstm.executeQuery();

        // 🔥 IMPORTANT FIX
            if (rs.next()) {
                return rs.getString("seat_status");
            } else {
            // Seat not found → AVAILABLE
                return SeatStatus.AVAILABLE.name();
            }

          } catch (SQLException e) {
                e.printStackTrace();
          } finally {
                mysql.closeConnection(conn);
        }

           return SeatStatus.UNAVAILABLE.name();
        }
    
    public int getSeatAmount(int showId, String seatNo) {

        Connection conn = mysql.openConnection();
        if (conn == null) {
            System.out.println("SeatDao: Failed to open DB connection");
            return 0;
        }

        String sql = "SELECT price FROM seats WHERE show_id=? AND seat_number=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, showId);
            pstm.setString(2, seatNo);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
            return rs.getInt("price");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        // seat not found → price 0
        return 0;
    }
    
    public double getTotalAmountBySeatCount(int numberOfTickets) {

        Connection conn = mysql.openConnection();
        if (conn == null) {
            System.out.println("SeatDao: Failed to open DB connection");
            return 0;
        }

        double totalAmount = 0;

        String sql = "{CALL reserve_seats_and_calculate_total(?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            // IN parameter
            cstmt.setInt(1, numberOfTickets);

            // OUT parameter
            cstmt.registerOutParameter(2, java.sql.Types.DECIMAL);

            // Execute procedure
            cstmt.execute();

            // Get OUT value
            totalAmount = cstmt.getDouble(2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        return totalAmount;
    }
    
//    public void markSeatSold(int showId, String seatNo) {
//        Connection conn = mysql.openConnection();
//
//        String sql = """
//            UPDATE seats
//            SET status = ?
//            WHERE show_id = ? AND seat_number = ?
//        """;
//
//        try (PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, SeatStatus.SOLD.name());  // or "SOLD"
//            ps.setInt(2, showId);
//            ps.setString(3, seatNo);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            mysql.closeConnection(conn);
//        }
//    }


}

    

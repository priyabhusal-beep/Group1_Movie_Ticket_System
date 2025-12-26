/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import database.MySqlConnection;
import model.BookingDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingDao {

    private final MySqlConnection mysql = new MySqlConnection();

    // ==================================================
    // 1️⃣ CREATE BOOKING & RETURN GENERATED BOOKING ID
    // ==================================================
    public int createBooking(BookingDetails booking) {

        Connection conn = mysql.openConnection();

        String sql = """
            INSERT INTO booking
            (userId, showId, seats_Number, total_Seats, seat_Price, total_Paying_Amount)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps =
                     conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getShowId());
            ps.setString(3, booking.getSeatsNumber());
            ps.setInt(4, booking.getTotalSeats());
            ps.setInt(5, booking.getSeatPrice());
            ps.setInt(6, booking.getTotalPayingAmount());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new RuntimeException("Booking creation failed.");
            }

            // ✅ GET GENERATED booking_id
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);   // booking_id
                } else {
                    throw new RuntimeException("No booking ID generated.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            mysql.closeConnection(conn);
        }
    }

    // ==================================================
    // 2️⃣ SAVE BOOKING SEATS
    // ==================================================
    public void saveBookingSeat(int bookingId, String seatNo, int seatPrice) {

        Connection conn = mysql.openConnection();

        String sql = """
            INSERT INTO booking_seats (booking_id, seat_number, seat_price)
            VALUES (?, ?, ?)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ps.setString(2, seatNo);
            ps.setInt(3, seatPrice);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
    }

    // ==================================================
    // 3️⃣ GET BOOKING DETAILS FOR CONFIRMATION SCREEN
    // ==================================================
    public BookingDetails getBookingDetails(int bookingId) {

        Connection conn = mysql.openConnection();
        BookingDetails details = new BookingDetails();

        String sql = """
            SELECT
                m.title            AS movie,
                t.name             AS theatre,
                GROUP_CONCAT(bs.seat_number) AS seats,
                COUNT(bs.seat_number)        AS totalSeats,
                b.seat_Price,
                b.total_Paying_Amount
            FROM booking b
            JOIN shows s          ON b.showId = s.show_id
            JOIN movies m         ON s.movie_id = m.movie_id
            JOIN theatres t       ON s.theatre_id = t.theatre_id
            JOIN booking_seats bs ON b.booking_id = bs.booking_id
            WHERE b.booking_id = ?
            GROUP BY b.booking_id
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                details.setMovieName(rs.getString("movie"));
                details.setTheaterName(rs.getString("theatre"));
                details.setSeatsNumber(rs.getString("seats"));
                details.setTotalSeats(rs.getInt("totalSeats"));
                details.setSeatPrice(rs.getInt("seat_Price"));
                details.setTotalPayingAmount(rs.getInt("total_Paying_Amount"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        return details;
    }
}

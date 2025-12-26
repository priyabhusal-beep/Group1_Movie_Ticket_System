///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

package controller;

import dao.BookingDao;
import dao.SeatSelectionDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.BookingDetails;
import model.SeatData;
import model.SeatStatus;
import view.BookingTicket;
import view.SeatSelection;

/**
 *
 * @author DELL
 */
public class SeatSelectionController {

    // =========================
    // STATE VARIABLES
    // =========================
    private int userId;
    private int showId;
    private int seatPrice = 200;
    private int totalAmount = 0;
    private String movieName;
    private String theaterName;

    private final List<String> selectedSeats = new ArrayList<>();

    // =========================
    // DAO & VIEW
    // =========================
    private final SeatSelectionDao seatDao = new SeatSelectionDao();
    private final BookingDao bookingDao = new BookingDao();
    private final SeatSelection sselection;

    // =========================
    // CONSTRUCTOR
    // =========================
    public SeatSelectionController(SeatSelection sselection, int userId, int showId) {
        this.sselection = sselection;
        this.userId = userId;
        this.showId = showId;

//        sselection.AddButtonseatsListener(new SeatSelectListener());
//        sselection.AddBuyTicketListener(new BuyTicketListener());
    }

    public SeatSelectionController(SeatSelection sselection) {
        this.sselection = sselection;
        sselection.AddButtonseatsListener(new SeatSelectListener());
        sselection.AddBuyTicketListener(new BuyTicketListener());
    }

    // =========================
    // VIEW CONTROL
    // =========================
    public void open() {
        sselection.setVisible(true);
    }

    public void close() {
        sselection.dispose();
    }

    // =========================
    // BUY TICKET LISTENER
    // =========================
    class BuyTicketListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (selectedSeats.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select at least one seat.");
                return;
            }

            // calculate total
            totalAmount = selectedSeats.size() * seatPrice;

            // CREATE booking object HERE (CORRECT PLACE)
            BookingDetails booking = new BookingDetails();

            booking.setTotalPayingAmount(totalAmount);   // 🔥 THIS LINE IS REQUIRED
            booking.setTotalSeats(selectedSeats.size());
            booking.setSeatPrice(seatPrice);
            booking.setSeatsNumber(String.join(", ", selectedSeats));
            booking.setUserId(userId);
            booking.setShowId(showId);


            // save booking
            int bookingId = bookingDao.createBooking(booking);
            
            if (bookingId == -1) {
            JOptionPane.showMessageDialog(null, "Booking failed!");
            return;
}

            // save seats
            for (String seatNo : selectedSeats) {
                bookingDao.saveBookingSeat(bookingId, seatNo, seatPrice);
               
            }

            // open booking confirmation
            // set movie & theater if not already
            booking.setMovieName(sselection.getMovieLabel().getText());
            //booking.setTheaterName(sselection.getTheaterName().getText());

            // open booking confirmation
            BookingTicket ticketView = new BookingTicket();
            BookingController bookingController = new BookingController(ticketView);

            // 🔥 PASS OBJECT, NOT ID
            bookingController.loadBookingDetails(booking);

            ticketView.setVisible(true);
            close();

            ticketView.setVisible(true);
            close();
        }
    }

    // =========================
    // SEAT SELECT LISTENER
    // =========================
    class SeatSelectListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();
        btn.setOpaque(true);

        String seatNo = btn.getText();

        // Toggle seat selection
        if (selectedSeats.contains(seatNo)) {
            selectedSeats.remove(seatNo);
            btn.setBackground(Color.WHITE);
        } else {
            selectedSeats.add(seatNo);
            btn.setBackground(Color.YELLOW);
        }

        // Calculate total
        totalAmount = selectedSeats.size() * seatPrice;

        // 🔥 UPDATE LABEL IN UI (THIS WAS THE ISSUE)
        sselection.getTotalAmount().setText(String.valueOf(totalAmount));


    }
}


}

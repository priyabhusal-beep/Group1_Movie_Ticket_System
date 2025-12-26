/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BookingDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BookingDetails;
import view.BookingTicket;
import view.SeatSelection;


public class BookingController {

    private BookingTicket view;
    private SeatSelection sselection;

    public BookingController(BookingTicket view) {
        this.view = view;
        view.getBackButton(new AddBackButtonListener());
        view.getConfirmBooking(new AddConfirmBookingLIstener());
    }

    public void loadBookingDetails(BookingDetails booking) {

        view.getMovie().setText(booking.getMovieName());
        view.getTheaterName().setText(booking.getTheaterName());
        view.getSeats().setText(booking.getSeatsNumber());
        view.getSeatsPrice().setText(String.valueOf(booking.getSeatPrice()));
        view.getTotalSeats().setText(String.valueOf(booking.getTotalSeats()));
        view.getTotalPayingAmount().setText(
            String.valueOf(booking.getTotalPayingAmount())
        );
    }

    class AddBackButtonListener implements ActionListener {

        public AddBackButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            SeatSelectionController ssc =new SeatSelectionController(sselection);
            ssc.open();
            view.dispose();
        }
    }

    class AddConfirmBookingLIstener implements ActionListener {

        public AddConfirmBookingLIstener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Confirm button ko logic yaha lekhne. 
            
        }
    }
}


//public class BookingController {
//
//    private final BookingDao bookingDao;
//    private final BookingTicket confirmView;
//
//    public BookingController(BookingTicket confirmView) {
//        this.confirmView = confirmView;
//        this.bookingDao = new BookingDao();
//    }
//
//    public void loadBookingDetails(int bookingId) {
//
//        BookingDetails details = bookingDao.getBookingDetails(bookingId);
//
//        if (details == null) {
//            System.out.println("No booking details found for bookingId = " + bookingId);
//            return;
//        }
//
//        confirmView.getMovie().setText(String.valueOf(movieName));
//        confirmView.getTheater().setText(String.valueOf(theaterName));
//        confirmView.getSeats().setText(String.valueOf(seatsNumber));
//        confirmView.getSeatsPrice().setText(String.valueOf(seatsPrice));        
//        confirmView.getTotalSeats().setText(String.valueOf(totalSeats));
//        confirmView.getTotalPayingAmount().setText(String.valueOf(totalPayingAmount));
//                
//        
//      
//
//    }

//}

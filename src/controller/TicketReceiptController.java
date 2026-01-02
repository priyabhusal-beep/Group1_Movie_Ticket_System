/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import javax.swing.ButtonGroup;
import model.BookingDetails;
import view.TicketReceipt;

/**
 *
 * @author DELL
 */
public class TicketReceiptController {
    
    private TicketReceipt view;
    
    public void open(){
        view.setVisible(true);
    }
    
    public void close(){
        view.dispose();
    }
    
    public TicketReceiptController(TicketReceipt view) {
    this.view = view;
}

    
     public void loadBookingDetails(BookingDetails booking) {

        view.getMovie().setText(booking.getMovieName());

        view.getSeats().setText(booking.getSeatsNumber());
        view.getSeatsPrice().setText(String.valueOf(booking.getSeatPrice()));
        view.getTotalSeats().setText(String.valueOf(booking.getTotalSeats()));
        view.getBookingTime().setText(String.valueOf(booking.getBookingTime()));
       
        
        
        view.getTotalAmount().setText(String.valueOf(booking.getTotalPayingAmount()));
        
        view.getPaymentMethodLabel().setText(booking.getPaymentMethod());

       
        
    }
}

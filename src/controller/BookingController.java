/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BookingDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.BookingDetails;
import view.BookingTicket;
import view.SeatSelection;
import view.TicketReceipt;


public class BookingController {
    
    private BookingDetails currentBooking;


    private BookingTicket view;
    private SeatSelection sselection;
    private TicketReceiptController tcR;
 

    public BookingController(BookingTicket view) {  
        this.view = view;
        this.sselection = sselection;
        view.getBackButton(new AddBackButtonListener());
        view.getConfirmBooking(new ConfirmBookingListener());
        
    }

    public void loadBookingDetails(BookingDetails booking) {
    this.currentBooking = booking;   // STORE IT

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

            @Override
            public void actionPerformed(ActionEvent e) {

                // 1️⃣ Create SeatSelection view
                SeatSelection seatView = new SeatSelection();

                // 2️⃣ Create controller with that view
                SeatSelectionController ssc =
                        new SeatSelectionController(seatView);

                // 3️⃣ Open seat selection
                ssc.open();

                // 4️⃣ Close booking ticket page
                view.dispose();
            }
        }


//    class AddConfirmBookingLIstener implements ActionListener {
//
//        public AddConfirmBookingLIstener() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            //Confirm button ko logic yaha lekhne.
//            StringString paymentMethod = null;
//
//            if (rbCash.isSelected()) {
//                System.out.println("Cash selected");
//            }
//            else if (rbCard.isSelected()) {
//                System.out.println("Card selected");
//            }
//            else if (rbEsewa.isSelected()) {
//                System.out.println("Esewa selected");
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Please select a payment method");
//                return; // VERY IMPORTANT
//            }
//
//            // continue booking logic here
//        }            
//        }
//    }
//


        class ConfirmBookingListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

            String paymentMethod = null;

            if (view.getRbCash().isSelected()) {
                paymentMethod = "Cash";
            }
            else if (view.getRbCard().isSelected()) {
                paymentMethod = "Card";
            }
            else if (view.getRbEsewa().isSelected()) {
                paymentMethod = "Esewa";
            }
            else {
                JOptionPane.showMessageDialog(
                    null,
                    "Please select a payment method",
                    "Payment Error",
                    JOptionPane.WARNING_MESSAGE
                );
                return; // STOP here
            }
            // 2) Ask confirmation (YES / NO)
            int choice = JOptionPane.showConfirmDialog(
                view,
                "Do you want to confirm your payment via " + paymentMethod + "?",
                "Confirm Payment",
                JOptionPane.YES_NO_OPTION
            );

            // 3) If NO → stay on same page
            if (choice != JOptionPane.YES_OPTION) {
                return;
            }

            // 4) If YES → generate ticket (success)
            // 4) If YES → generate ticket (success)
            JOptionPane.showMessageDialog(
                view,
                "🎟 Ticket Generated Successfully!\n\n"
                + "Payment Method: " + paymentMethod,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            // SAVE payment method
            currentBooking.setPaymentMethod(paymentMethod);
            currentBooking.setBookingTime(LocalDate.now());
            currentBooking.setShowTime(LocalDate.of(2026, 1, 5)); // replace with DB later


            // OPEN RECEIPT
            TicketReceipt receiptView = new TicketReceipt();
            TicketReceiptController receiptController =
                    new TicketReceiptController(receiptView);

            receiptController.loadBookingDetails(currentBooking);
            receiptController.open();

            // close booking ticket page
            view.dispose();


                    
                 

    // OPTIONAL: close ticket page after success
    // view.dispose();
}

        }
}
    


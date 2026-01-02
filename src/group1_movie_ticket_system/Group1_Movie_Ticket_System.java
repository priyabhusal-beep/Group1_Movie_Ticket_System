/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group1_movie_ticket_system;


import controller.BookingController;
import controller.SeatSelectionController;
import controller.SignUpController;
import controller.TheaterController;
import database.Database;
import database.MySqlConnection;
import view.SeatSelection;
import java.sql.*;
import view.BookingTicket;
import view.SignUp;
//import view.TheaterView;





/**
 *
 * @author DELL
 */
public class Group1_Movie_Ticket_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

          Database db = new MySqlConnection();
          Connection conn = db.openConnection();
        if(conn != null) {
            System.out.println("Connection opened");
            db.closeConnection(conn);
        }else {
            System.out.println("Connection closed");
        }
//        
        SignUp signupview = new SignUp();
        SignUpController controller = new SignUpController(signupview);
        controller.open();
        
//        
//        SeatSelection seatView = new SeatSelection();
//        SeatSelectionController controller = new SeatSelectionController(seatView);
//        controller.open();
//////        
        
//        BookingTicket view = new BookingTicket();
//        BookingController see = new BookingController(view);
//        view.setVisible(true);
//
//        
//        TheaterView theatreView = new TheaterView();
//        TheaterController controller = new TheaterController(theatreView);
//        controller.open();
//        
                
                
    
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group1_movie_ticket_system;

import view.SignUp;
import controller.SignUpController;
import database.Database;
import database.MySqlConnection;
import java.sql.*;

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
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                SignUp signUpView = new SignUp();
////                SignUpController controller = new SignUpController(signUpView);
////                controller.open();
////            }
////        });
    }
    
}

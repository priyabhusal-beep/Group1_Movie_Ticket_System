/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group1_movie_ticket_system;

import database.demo.Database;
import database.demo.MySqlConnection;

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
        if(db.openConnection() !=null) {
            System.out.println("Connection opened");
        
        }else {
            System.out.println("Connection closed");
        }
    }
    
}

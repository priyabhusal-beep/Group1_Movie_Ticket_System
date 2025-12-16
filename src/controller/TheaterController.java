/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author suman
 */
import dao.TheaterDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Theater;
import java.util.List;
import view.TheaterView;

public class TheaterController {

    private final TheaterDao theaterDao=new TheaterDao();
    private final TheaterView theaterView;

    public TheaterController(TheaterView theaterView) {
        this.theaterView = theaterView;
        theaterView.Addmov1ButtonListener(new AddButton1Listener());
        theaterView.Addmov2ButtonListener(new AddButton2Listener());
    }
    
    public void open(){
        this.theaterView.setVisible(true);
    }
    
    public void close(){
        this.theaterView.dispose();
    }
//    public List<Theater> getAllTheaters() {
//        return theaterDao.getAllTheaters();
//    }
//
//    public void displayTheaters() {
//        List<Theater> theaters = getAllTheaters();
//
//        if (theaters.isEmpty()) {
//            System.out.println("No theaters found.");
//        } else {
//            System.out.println("Theaters:");
//            for (Theater t : theaters) {
//                System.out.println("ID: " + t.getTheaterId() +
//                                   ", Name: " + t.getName() +
//                                   ", Location: " + t.getLocation());
//            }
//        }
//    }
    class AddButton2Listener implements ActionListener {

        public AddButton2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Button2 is Clickable");

        }
    }

//    public static void main(String[] args) {
//        TheaterController controller = new TheaterController();
//        controller.displayTheaters();
//    }

    class AddButton1Listener implements ActionListener{

        public AddButton1Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            // Button click garesi k garne vanne logic esma lekhne 
            
            System.out.println("Button1 is Clickable");
        }
    }
    
    
  
        
    
}

class Test{
    public static void main(String[] args) {
        TheaterView theaterView = new TheaterView();
        TheaterController theaterController = new TheaterController(theaterView);
        theaterController.open();
        
    }
}


package controller;

import view.TheaterView;
import view.Tereiskme_summary;
import view.Akhanda_summary;
import view.paran_summary;
import view.dhurandar_summary;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheaterController {

    private final TheaterView theaterView; // Do NOT assign null here

    public TheaterController(TheaterView theaterView) {
        this.theaterView = theaterView; // assign once in constructor

        // wire buttons to open the corresponding summary screens
        this.theaterView.Addmov1ButtonListener(e -> {
            JButton src = (JButton) e.getSource();
            src.setEnabled(false);
            System.out.println("TheaterController: opening Tereiskme_summary");
            theaterView.dispose();
            String showTime = theaterView.getSelectedShowTime();
            Tereiskme_summary sum = new Tereiskme_summary();
            sum.setShowInfo("Tere Ishq Mein (" + showTime + ")");
            sum.setVisible(true);
        });

        this.theaterView.Addmov2ButtonListener(e -> {
            JButton src = (JButton) e.getSource();
            src.setEnabled(false);
            System.out.println("TheaterController: opening Akhanda_summary");
            theaterView.dispose();
            String showTime = theaterView.getSelectedShowTime();
            Akhanda_summary sum = new Akhanda_summary();
            sum.setShowInfo("Akhanda 2 - Thaandavam (" + showTime + ")");
            sum.setVisible(true);
        });

        this.theaterView.Addmov3ButtonListener(e -> {
            JButton src = (JButton) e.getSource();
            src.setEnabled(false);
            System.out.println("TheaterController: opening paran_summary");
            theaterView.dispose();
            paran_summary sum = new paran_summary();
            sum.setVisible(true);
        });

        this.theaterView.Addmov4ButtonListener(e -> {
            JButton src = (JButton) e.getSource();
            src.setEnabled(false);
            System.out.println("TheaterController: opening dhurandar_summary");
            theaterView.dispose();
            dhurandar_summary sum = new dhurandar_summary();
            sum.setVisible(true);
        });
    }

    // Open the TheatreView
    public void open() {
        theaterView.setVisible(true);
    }

    // Close the TheatreView
    public void close() {
        theaterView.dispose();
    }
}


package controller;
import view.TheaterView;

public class TheaterController {

    private final TheaterView theaterView; // Do NOT assign null here

    public TheaterController(TheaterView theaterView) {
        this.theaterView = theaterView; // Correct: assign once in constructor
        // No listeners needed because all button actions are handled in the view
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


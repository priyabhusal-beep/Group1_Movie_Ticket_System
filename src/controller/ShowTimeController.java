/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author suman
 */
import dao.ShowTimeDao;
import model.ShowTime;
import java.util.List;

public class ShowTimeController {

    private ShowTimeDao ShowTimeDao;

    public ShowTimeController() {
        ShowTimeDao = new ShowTimeDao();
    }

    public List<ShowTime> getAllShowTimes() {
        return ShowTimeDao.getAllShowTimes();
    }

    public void displayShowTimes() {
        List<ShowTime> showTimes = getAllShowTimes();

        if (showTimes.isEmpty()) {
            System.out.println("No showtimes found.");
        } else {
            System.out.println("Showtimes:");
            for (ShowTime s : showTimes) {
                System.out.println("ID: " + s.getShowtimeId() +
                                   ", Theater ID: " + s.getTheaterId() +
                                   ", Movie: " + s.getMovieName() +
                                   ", Time: " + s.getTime());
            }
        }
    }

    public static void main(String[] args) {
        ShowTimeController controller = new ShowTimeController();
        controller.displayShowTimes();
    }
}



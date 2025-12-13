/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author suman
 */


public class ShowTime {
    private int showtimeId;
    private int theaterId;
    private String movieName;
    private String time;

    public ShowTime(int showtimeId, int theaterId, String movieName, String time) {
        this.showtimeId = showtimeId;
        this.theaterId = theaterId;
        this.movieName = movieName;
        this.time = time;
    }

    // getters
    public int getShowtimeId() { return showtimeId; }
    public int getTheaterId() { return theaterId; }
    public String getMovieName() { return movieName; }
    public String getTime() { return time; }
}


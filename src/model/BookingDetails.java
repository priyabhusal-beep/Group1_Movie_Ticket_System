/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class BookingDetails {
    private String movieName;
    private String theaterName;
    private String seatsNumber;
    private int totalSeats;
    private int userId;
    private int showId;
    private int seatPrice;
    private int totalPayingAmount;
    private LocalDate bookingTime ;
    private LocalDate showTime;
    private String paymentMethod;
    
    public BookingDetails(String movieName,String theaterName, String seatsNumber, int totalSeats, int totalPayingAmount  ){
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.seatsNumber = seatsNumber;
        this.totalSeats = totalSeats;
        this.userId = userId;
        this.showId = showId;
   
        this.totalPayingAmount = totalPayingAmount;
    }

    public BookingDetails() {
        // empty constructor
    }

    // getters & setters

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }
    
    public String getMovieName(){
        return movieName;
    }
   
    public void setTheaterName(String theaterName){
        this.theaterName = theaterName;
    }
    
    public String getTheaterName(){
        return theaterName;
    }
 
    public void setSeatsNumber(String seatsNumber){
        this.seatsNumber = seatsNumber;
    }
    
    public String getSeatsNumber(){
        return seatsNumber;
    }

    public void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }
    
    public int getTotalSeats(){
        return totalSeats;
        
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public int getUserId(){
        return userId;
        
    }
    
    public void setShowId(int showId){
        this.showId = showId;
    }
    
    public int getShowId(){
        return showId;
        
    }
    
    public void setSeatPrice(int seatPrice){
        this.seatPrice = seatPrice;
    }
    
    public int getSeatPrice(){
        return seatPrice;
    }
    public void setTotalPayingAmount(int totalPayingAmount){
        this.totalPayingAmount = totalPayingAmount;
    }
    
    public int getTotalPayingAmount(){
        return totalPayingAmount;
    }
    
    public LocalDate getBookingTime(){
        return bookingTime;
    }
 
    public void setBookingTime(LocalDate bookingTime){
        this.bookingTime = bookingTime;
    }
    
    public LocalDate getShowTime(){
        return showTime;
    }
    
    public void setShowTime(LocalDate showTime){
        this.showTime = showTime;
    }
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
}
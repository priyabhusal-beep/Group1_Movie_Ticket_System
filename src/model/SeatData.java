/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */

public class SeatData {
   
    private String seatNumber;
    private SeatStatus status;
    private int seatPrice;
    private int totalAmount;

    public SeatData(String seatNumber, SeatStatus status, int seatPrice, int totalAmount) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.seatPrice = seatPrice;
        this.totalAmount = totalAmount;
    }
    
    public SeatData(String seatNumber){
        this.seatNumber=seatNumber;
    }


    public void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }
    
    public String getSeatNumber(){
        return seatNumber;
    }
    
    public void setStatus(SeatStatus status){
        this.status = status;
    }
    
    public String getStatus(){
        return seatNumber;
    }
     
    public void setSeatPrice(int seatPrice){
        this.seatPrice = seatPrice;
    }
    
    public int getSeatPrice(){
        return seatPrice;
    }
    
    public void setAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
    
    public int getAmount(){
        return totalAmount;
    }

}
  

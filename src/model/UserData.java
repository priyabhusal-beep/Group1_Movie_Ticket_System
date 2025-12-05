/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class UserData {
    private int user_id;   
    private String mobileNumber;
    private String email;
    private String fullName;
    private String password;
    
    public UserData(String mobileNumber, String email, String fullName, String password) {
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.fullName = fullName;
        this.password = password;    
    }
    
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber= mobileNumber;
    }
    
    public String getMobileNumber(){
        return mobileNumber;
    }
    
    public void setUserID(int user_id){
        this.user_id = user_id;
    }
    
    public int getUserID(){
        return user_id;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setFullName (String fullName){
        this.fullName=fullName;
    }
   
    public String getFullName () {
        return fullName;
    }
    
    public void setpassword (String password){
        this.password=password;
    }
    
    public String getPassword () {
        return password;
    }
    
   
   
    
}

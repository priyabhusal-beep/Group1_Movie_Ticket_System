/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author suman
 */
package model;

public class Theater {
    private int theaterId;
    private String name;
    private String location;

    public Theater(int theaterId, String name, String location) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
    }

    // getters
    public int getTheaterId() { return theaterId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
}


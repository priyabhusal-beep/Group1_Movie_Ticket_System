/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database.demo;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public interface Database {
    Connection openConnection();
    void closeConnection (Connection conn);
    ResultSet runQuery (Connection conn, String query);
    int executeUpdate(Connection conn, String query);
        
}
    


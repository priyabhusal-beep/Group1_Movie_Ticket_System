/* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package database;
/* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;

/**
 *
 * @author salaj
 */
public interface Database {
    Connection openConnection();
    void closeConnection (Connection conn);
    ResultSet runQuery (Connection conn, String query);
    int executeUpdate(Connection conn, String query);
        
}
    


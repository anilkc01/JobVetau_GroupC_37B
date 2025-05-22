/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.*;

/**
 *
 * @author thismac
 */
public interface database {
    Connection openConnection();
    void closeConnection(Connection conn);
    ResultSet RunQuery(Connection conn, String query);
    int executeUpdate(Connection conn, String query);
    
}

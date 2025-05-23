/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Database.MySqlConnection;
import Model.userData;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class dao {
    
    public void signUp(userData user){
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();
        String sql = "INSERT INTO users(name,uname,email,number,address,role, password) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = conn1.prepareStatement(sql)){
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getUsername());
            pstm.setString(3,user.getEmail());
            pstm.setString(4,user.getNumber());
            pstm.setString(5,user.getAddress());
            pstm.setString(6,user.getRole());
            pstm.setString(7,user.getPassword());
            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, " successful");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        }catch(SQLException ex){
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mySql.closeConnection(conn1);
        }
    }
    
    public boolean checkUser(userData user) {
         MySqlConnection mySql = new MySqlConnection();
        Connection conn2 = mySql.openConnection();
        String sql = "SELECT * FROM users WHERE  uname = ?";
        try (PreparedStatement pstmt = conn2.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                JOptionPane.showMessageDialog(null, "Duplicate");
            }
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySql.closeConnection(conn2);
        }
        return false;
    }
    
    
    public void logIn(String username, String password) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();
        String sql = "SELECT * FROM users WHERE uname = ? AND password = ?";

        try (PreparedStatement pstm = conn1.prepareStatement(sql)) {
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery(); 

            if (rs.next()) {
                // Login successful
                JOptionPane.showMessageDialog(null, "Login successful");
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Login failed: Invalid username or password");
            }

        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred during login");
        } finally {
            mySql.closeConnection(conn1);
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Database.MySqlConnection;
import Model.companyData;
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
    
     public boolean signUp(userData user) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();
        String sql = "INSERT INTO users(name, uname, email, number, address, role, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getEmail());
            pstm.setString(4, user.getNumber());
            pstm.setString(5, user.getAddress());
            pstm.setString(6, user.getRole());
            pstm.setString(7, user.getPassword());
            int rowsAffected = pstm.executeUpdate();
            System.out.println(rowsAffected);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Signup successful");
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Signup Failed");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Signup error: " + ex.getMessage());
        } finally {
            mySql.closeConnection(conn1);
        }
        return false; 
    }
    
    
    public String checkUser(String userName) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn2 = mySql.openConnection();
        String sql = "SELECT * FROM users WHERE  uname = ?";
        try (PreparedStatement pstmt = conn2.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                
                return result.getString("role");
            } else {
                return "null";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySql.closeConnection(conn2);
        }
        return "null";
    }
    
    
    public int logIn(String username, String password) {
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
                return rs.getInt("id");
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Login failed: Invalid username or password");
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred during login");
        } finally {
            mySql.closeConnection(conn1);
        }
        
        return 0;
    }
    
    public companyData getCompanyData(int id) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();

        String sql = "SELECT u.name, u.uname, u.number, u.email, u.address, u.role, u.password, "
                + "c.photo, c.sector, c.employees, c.ceo, c.website,c.regNo, c.service "
                + "FROM users u LEFT JOIN companies c ON u.id = c.id WHERE u.id = ?";
       
        try (PreparedStatement pstm = conn1.prepareStatement(sql)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                
                String name = rs.getString("name");
                String username = rs.getString("uname");
                String number = rs.getString("number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("role");
                String password = rs.getString("password");
               

                // Company table fields may be null
                String photo = rs.getString("photo");
                String sector = rs.getString("sector");
                int employees = rs.getObject("employees") != null ? rs.getInt("employees") : 0;
                String ceo = rs.getString("ceo");
                String website = rs.getString("website");
                String service = rs.getString("service");
                String regNo = rs.getString("regNo");
                
                companyData cData = new companyData(name, username, number, email, address, role, password,
                        photo, sector, employees, ceo, website, service, regNo);
                cData.setId(id);
                
                return cData;
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the given ID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while fetching company data");
        } finally {
            mySql.closeConnection(conn1);
        }

        return null;
    }

    public void updateCompany(companyData company) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        String userSql = "UPDATE users SET name=?, uname=?, number=?, email=?, address=?, role=?, password=? WHERE id=?";
        String checkSql = "SELECT id FROM companies WHERE id=?";
        String updateCompanySql = "UPDATE companies SET photo=?, regNo=?, sector=?, employees=?, ceo=?, website=?, service=? WHERE id=?";
        String insertCompanySql = "INSERT INTO companies (id, photo, regNo, sector, employees, ceo, website, service) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(company.getId());
        try ( PreparedStatement userStmt = conn.prepareStatement(userSql);
              PreparedStatement checkStmt = conn.prepareStatement(checkSql);
              PreparedStatement updateStmt = conn.prepareStatement(updateCompanySql);
              PreparedStatement insertStmt = conn.prepareStatement(insertCompanySql)) {

            // Update users table
            userStmt.setString(1, company.getName());
            userStmt.setString(2, company.getUsername());
            userStmt.setString(3, company.getNumber());
            userStmt.setString(4, company.getEmail());
            userStmt.setString(5, company.getAddress());
            userStmt.setString(6, company.getRole());
            userStmt.setString(7, company.getPassword());
            userStmt.setInt(8, company.getId());
            userStmt.executeUpdate();

            // Check if company exists
            checkStmt.setInt(1, company.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Update companies table
                updateStmt.setString(1, company.getPhoto());
                updateStmt.setString(2, company.getRegNo());
                updateStmt.setString(3, company.getSector());
                updateStmt.setInt(4, company.getEmployees());
                updateStmt.setString(5, company.getCeo());
                updateStmt.setString(6, company.getWebsite());
                updateStmt.setString(7, company.getService());
                updateStmt.setInt(8, company.getId());
                updateStmt.executeUpdate();
            } else {
                // Insert into companies table
                insertStmt.setInt(1, company.getId());
                insertStmt.setString(2, company.getPhoto());
                insertStmt.setString(3, company.getRegNo());
                insertStmt.setString(4, company.getSector());
                insertStmt.setInt(5, company.getEmployees());
                insertStmt.setString(6, company.getCeo());
                insertStmt.setString(7, company.getWebsite());
                insertStmt.setString(8, company.getService());
                insertStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Replace with logging if needed
        }
    }


    
}

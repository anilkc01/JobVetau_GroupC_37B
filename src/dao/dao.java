/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Database.MySqlConnection;
import Model.companyData;
import Model.*;
import java.sql.*;
import java.util.ArrayList;
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
        try (PreparedStatement userStmt = conn.prepareStatement(userSql);
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

    public seekerData getSeekerData(int id) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();

        String sql = "SELECT u.name, u.uname, u.number, u.email, u.address, u.role, u.password, "
                + "s.photo, s.idNo, s.DOB, s.experience, s.specialization, s.protfolio "
                + "FROM users u LEFT JOIN seekers s ON u.id = s.id WHERE u.id = ?";

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

                // Seeker table fields may be null
                String photo = rs.getString("photo");
                String idNo = rs.getString("idNo");
                String dob = rs.getString("DOB");
                String experience = rs.getString("experience");
                String specialization = rs.getString("specialization");
                String portfolio = rs.getString("protfolio");

                seekerData sData = new seekerData(photo, idNo, dob, experience, specialization, portfolio,
                        name, username, number, email, address, role, password);
                sData.setId(id);

                return sData;
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the given ID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while fetching seeker data");
        } finally {
            mySql.closeConnection(conn1);
        }

        return null;
    }
    
    public void updateSeeker(seekerData seeker) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        String userSql = "UPDATE users SET name=?, uname=?, number=?, email=?, address=?, role=?, password=? WHERE id=?";
        String checkSql = "SELECT id FROM seekers WHERE id=?";
        String updateSeekerSql = "UPDATE seekers SET photo=?, idNo=?, DOB=?, experience=?, specialization=?, protfolio=? WHERE id=?";
        String insertSeekerSql = "INSERT INTO seekers (id, photo, idNo, DOB, experience, specialization, protfolio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement userStmt = conn.prepareStatement(userSql);
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                PreparedStatement updateStmt = conn.prepareStatement(updateSeekerSql);
                PreparedStatement insertStmt = conn.prepareStatement(insertSeekerSql)) {
            // Update users table
            userStmt.setString(1, seeker.getName());
            userStmt.setString(2, seeker.getUsername());
            userStmt.setString(3, seeker.getNumber());
            userStmt.setString(4, seeker.getEmail());
            userStmt.setString(5, seeker.getAddress());
            userStmt.setString(6, seeker.getRole());
            userStmt.setString(7, seeker.getPassword());
            userStmt.setInt(8, seeker.getId());
            userStmt.executeUpdate();

            // Check if seeker exists
            checkStmt.setInt(1, seeker.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Update seekers table
                updateStmt.setString(1, seeker.getPhoto());
                updateStmt.setString(2, seeker.getIdNo());
                updateStmt.setString(3, seeker.getDOB());
                updateStmt.setString(4, seeker.getExperience());
                updateStmt.setString(5, seeker.getSpecialization());
                updateStmt.setString(6, seeker.getProtfolio());
                updateStmt.setInt(7, seeker.getId());
                updateStmt.executeUpdate();
            } else {
                // Insert into seekers table
                insertStmt.setInt(1, seeker.getId());
                insertStmt.setString(2, seeker.getPhoto());
                insertStmt.setString(3, seeker.getIdNo());
                insertStmt.setString(4, seeker.getDOB());
                insertStmt.setString(5, seeker.getExperience());
                insertStmt.setString(6, seeker.getSpecialization());
                insertStmt.setString(7, seeker.getProtfolio());
                insertStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // You can replace with proper logging
        } finally {
            mySql.closeConnection(conn);
        }
    }

    public void deleteUser(int id) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        String deleteUserSql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement userStmt = conn.prepareStatement(deleteUserSql)) {
            userStmt.setInt(1, id);
            int rowsAffected = userStmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the given ID.");
            }

        } catch (SQLException e) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error deleting user: " + e.getMessage());
        } finally {
            mySql.closeConnection(conn);
        }
    }

    public boolean addJob(jobData job) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        String sql = "INSERT INTO jobs (title, description, location, salary, mode, company_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getDescription());
            stmt.setString(3, job.getLocation());
            stmt.setString(4, job.getSalary());
            stmt.setString(5, job.getMode());
            stmt.setInt(6, job.getCompanyId());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Added Successfully");
                return true;
            } else{
                JOptionPane.showMessageDialog(null, " Failed to Add Job");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Or log error
            JOptionPane.showMessageDialog(null, "Failed to add job: " + e.getMessage());
        } finally {
            mySql.closeConnection(conn);
        }
        return false;
    }

    public ArrayList<jobData> getOurJobs(int uid) {
        ArrayList<jobData> jobList = new ArrayList<>();
        MySqlConnection mySql = new MySqlConnection();
        Connection conn1 = mySql.openConnection();

        String sql = "SELECT * FROM jobs WHERE company_id = ?";

        try (PreparedStatement pstm = conn1.prepareStatement(sql)) {
            pstm.setInt(1, uid);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String mode = rs.getString("mode");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String salary = rs.getString("salary");

                jobData job = new jobData(title, description, location, salary, mode);
                job.setId(id);

                jobList.add(job);
            }

            if (jobList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No jobs found for the given company ID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(dao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while fetching job data");
        } finally {
            mySql.closeConnection(conn1);
        }

        return jobList;
    }

    public boolean deleteJob(int jobId) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        String sql = "DELETE FROM jobs WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jobId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            System.err.println("Error deleting job with ID " + jobId + ": " + e.getMessage());
            return false; // Return false on error
        }
    }
    
    public boolean addApplication(applicationData application) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        boolean success = false;

        try {
            String sql = "INSERT INTO applications (seeker_id, job_id, status) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, application.getSeekerId());
            ps.setInt(2, application.getJobId());
            ps.setString(3, application.getStatus() != null ? application.getStatus() : "Pending");

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected > 0;

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySql.closeConnection(conn);
        }

        return success;
    }
    
    public ArrayList<appliedJobData> getJobs(int seekerId, String sortOrder) {
        ArrayList<appliedJobData> jobList = new ArrayList<>();
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        try {
            String sql = "CALL getJobs(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ps.setString(2, sortOrder);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appliedJobData job = new appliedJobData(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getString("salary"),
                        rs.getString("mode"),
                        "null"
                );

                job.setId(rs.getInt("id"));
                job.setPostedDate(rs.getString("posted_date"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setCompanyName(rs.getString("company_name"));
                jobList.add(job);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySql.closeConnection(conn);
        }

        return jobList;
    }


    public ArrayList<appliedJobData> searchJobs(int seekerId, String searchTerm, String sortOrder) {
        ArrayList<appliedJobData> jobList = new ArrayList<>();
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        try {
            String sql = "CALL searchJobs(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ps.setString(2, searchTerm);
            ps.setString(3, sortOrder);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appliedJobData job = new appliedJobData(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getString("salary"),
                        rs.getString("mode"),
                        "null"
                );

                job.setId(rs.getInt("id"));
                job.setPostedDate(rs.getString("posted_date"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setCompanyName(rs.getString("company_name"));
                jobList.add(job);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySql.closeConnection(conn);
        }

        return jobList;
    }


    public ArrayList<appliedJobData> getAppliedJobs(int seekerId) {
        ArrayList<appliedJobData> jobList = new ArrayList<>();
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        try {
            String sql = "CALL getAppliedJobs(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appliedJobData job = new appliedJobData(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getString("salary"),
                        rs.getString("mode"),
                        rs.getString("status")
                );

                job.setId(rs.getInt("id"));
                job.setPostedDate(rs.getString("posted_date"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setCompanyName(rs.getString("company_name"));

                jobList.add(job);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySql.closeConnection(conn);
        }

        return jobList;
    }

    public boolean withdrawApplication(int seekerId, int jobId) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        boolean success = false;

        try {
            String sql = "DELETE FROM applications WHERE seeker_id = ? AND job_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, seekerId);
            ps.setInt(2, jobId);

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected > 0;

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySql.closeConnection(conn);
        }

        return success;
    }
    
    public ArrayList<companyData> getAllCompanies() {
          MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        ArrayList<companyData> companies = new ArrayList<>();
        String query = "SELECT u.id, c.photo, u.name, u.email, u.number, u.address "
                + "FROM users u JOIN companies c ON u.id = c.id";

        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                companyData company = new companyData(
                        rs.getString("name"),
                        "", // username (not required)
                        rs.getString("number"),
                        rs.getString("email"),
                        rs.getString("address"),
                        "", // role (not required)
                        "", // password (not required)
                        rs.getString("photo"),
                        "", 0, "", "", "", "" // other fields not needed
                );
                company.setId(rs.getInt("id"));
                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mySql.closeConnection(conn);
        }
        return companies;
    }

    public ArrayList<seekerData> getAllSeekers() {
          MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        ArrayList<seekerData> seekers = new ArrayList<>();
        String query = "SELECT u.id, s.photo, u.name, u.email, u.number, u.address "
                + "FROM users u JOIN seekers s ON u.id = s.id";

        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                seekerData seeker = new seekerData(
                        rs.getString("photo"),
                        "", "", "", "", "", // extra seeker fields
                        rs.getString("name"),
                        "", // username
                        rs.getString("number"),
                        rs.getString("email"),
                        rs.getString("address"),
                        "", // role
                        "" // password
                );
                seeker.setId(rs.getInt("id"));
                seekers.add(seeker);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mySql.closeConnection(conn);
        }
        return seekers;
    }

    public ArrayList<jobData> getAllJobs() {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        ArrayList<jobData> jobs = new ArrayList<>();
        String query = "SELECT j.id, j.title, j.description, j.location, j.mode, j.salary, u.name AS company_name "
                + "FROM jobs j JOIN companies c ON j.company_id = c.id "
                + "JOIN users u ON c.id = u.id";

        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                jobData job = new jobData(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getString("salary"),
                        rs.getString("mode")
                );
                job.setId(rs.getInt("id"));
                job.setCompanyName(rs.getString("company_name"));
                jobs.add(job);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            mySql.closeConnection(conn);
        }
        return jobs;
    }

    public ArrayList<applicationData> getApplications(int jobId) {
        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();
        
        ArrayList<applicationData> applications = new ArrayList<>();
        String sql = "SELECT * FROM applications WHERE job_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jobId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                applicationData app = new applicationData(
                    rs.getInt("seeker_id"),
                    rs.getInt("job_id"),
                    rs.getString("status")
                );
                app.setId(rs.getInt("id"));
                applications.add(app);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }
        
    public boolean updateStatus(int id, String status) {

        MySqlConnection mySql = new MySqlConnection();
        Connection conn = mySql.openConnection();

        String sql = "{CALL update_status(?, ?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, status);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // true if update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

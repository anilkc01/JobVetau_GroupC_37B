package dao;

import Database.MySqlConnection;
import Model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JobDAO {
    private final MySqlConnection dbConnection;

    public JobDAO() {
        this.dbConnection = new MySqlConnection();
    }

    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        Connection conn = null;
        
        try {
            conn = dbConnection.openConnection();
            String query = "SELECT * FROM jobs";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Job job = new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getDouble("salary"),
                    rs.getString("posteddate"),
                    rs.getInt("companyid")
                );
                jobs.add(job);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error loading job data: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            if (conn != null) {
                dbConnection.closeConnection(conn);
            }
        }
        
        return jobs;
    }
    
    public Job getJobById(int id) {
        return jobs.stream()
                  .filter(job -> job.getId() == id)
                  .findFirst()
                  .orElse(null);
    }
} 
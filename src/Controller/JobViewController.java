package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.MySqlConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JobViewController {
    private JFrame frame;
    private JTable jobTable;
    private DefaultTableModel tableModel;
    private final MySqlConnection dbConnection;

    public JobViewController() {
        dbConnection = new MySqlConnection();
        initializeUI();
        loadJobData();
    }

    private void initializeUI() {
        frame = new JFrame("Job Listings");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);

        String[] columnNames = {"ID", "Title", "Description", "Location", "Salary", "Mode", "Posted Date", "Company ID"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        jobTable = new JTable(tableModel);
        jobTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumnModel columnModel = jobTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);  // ID
        columnModel.getColumn(1).setPreferredWidth(150); // Title
        columnModel.getColumn(2).setPreferredWidth(300); // Description
        columnModel.getColumn(3).setPreferredWidth(100); // Location
        columnModel.getColumn(4).setPreferredWidth(80);  // Salary
        columnModel.getColumn(5).setPreferredWidth(80);  // Mode
        columnModel.getColumn(6).setPreferredWidth(100); // Posted Date
        columnModel.getColumn(7).setPreferredWidth(80);  // Company ID

        JScrollPane scrollPane = new JScrollPane(jobTable);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        frame.setLocationRelativeTo(null);
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    private void loadJobData() {
        Connection conn = null;
        try {
            conn = dbConnection.openConnection();
            String query = "SELECT * FROM jobs";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getDouble("salary"),
                    rs.getString("mode"),
                    rs.getString("posteddate"),
                    rs.getInt("companyid")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame,
                "Error loading job data: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            if (conn != null) {
                dbConnection.closeConnection(conn);
            }
        }
    }
}
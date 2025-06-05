package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class viewjobpage extends JFrame {
    private JTable jTable1;
    private JScrollPane scrollPane;

    public viewjobpage() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Available Jobs");
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // Create table with columns
        String[] columnNames = {"ID", "Title", "Description", "Location", "Salary", "Posted Date", "Company ID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };

        jTable1 = new JTable(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Set column widths
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150); // Title
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300); // Description
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100); // Location
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);  // Salary
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100); // Posted Date
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);  // Company ID

        scrollPane = new JScrollPane(jTable1);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public JTable getjTable1() {
        return jTable1;
    }
} 
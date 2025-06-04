package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class viewjobpage extends JFrame {
    private JTable jTable1;
    private JScrollPane jScrollPane1;

    public viewjobpage() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Available Jobs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // Initialize components
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        // Setup table model
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Title", "Description", "Location", "Salary", "Post Date", "Company ID"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, String.class, String.class, Float.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        // Configure table appearance
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setReorderingAllowed(false);
        
        // Add table to scroll pane
        jScrollPane1.setViewportView(jTable1);

        // Add scroll pane to frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    }

    public JTable getjTable1() {
        return jTable1;
    }
} 
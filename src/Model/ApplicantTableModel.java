/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ApplicantTableModel extends AbstractTableModel {
    private final String[] columns = {"SN", "Name", "Exp.", "Action"};
    private final List<Applicant> data;

    public ApplicantTableModel(List<Applicant> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Applicant a = data.get(row);
        return switch (column) {
            case 0 -> a.getSn();
            case 1 -> a.getName();
            case 2 -> a.getExperience();
            case 3 -> "Action";
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 3;
    }
}


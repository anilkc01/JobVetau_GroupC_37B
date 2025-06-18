/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.ApplicationsController;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JButton acceptBtn = new JButton("Accept");
    private final JButton rejectBtn = new JButton("Reject");
    private final JTable table;
    private final ApplicationsController controller;

    public ButtonEditor(ApplicationsController controller, JTable table) {
        this.controller = controller;
        this.table = table;

        panel.add(acceptBtn);
        panel.add(rejectBtn);

        acceptBtn.addActionListener(e -> {
            int row = table.getEditingRow();
            controller.acceptApplicant(row);
            fireEditingStopped();
        });

        rejectBtn.addActionListener(e -> {
            int row = table.getEditingRow();
            controller.rejectApplicant(row);
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}


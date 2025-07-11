/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.seekerData;
import javax.swing.ImageIcon;

/**
 *
 * @author thismac
 */
public class applicantCard extends javax.swing.JPanel {
    private seekerData seeker = null;

    /**
     * Creates new form applicantCard
     */
    public applicantCard(seekerData seeker) {
        this.seeker = seeker;
        System.out.println(seeker.getName());
        initComponents();
        setValues();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        skrLogo = new javax.swing.JLabel();
        skrName = new javax.swing.JLabel();
        skrExp = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        skrLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/skrLogo.png"))); // NOI18N

        skrName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        skrName.setText("Anil KC");

        skrExp.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        skrExp.setText("Anil KC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(skrLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skrName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skrExp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(skrName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skrExp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(skrLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel skrExp;
    private javax.swing.JLabel skrLogo;
    private javax.swing.JLabel skrName;
    // End of variables declaration//GEN-END:variables

    private void setValues() {
        skrName.setText(seeker.getName());
        skrExp.setText(seeker.getExperience()+ "Yrs");
        String path = seeker.getPhoto();
        if (path != null && !path.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(path);
                skrLogo.setIcon(icon);
            } catch (Exception e) {
                skrLogo.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
            }
        } else {
            skrLogo.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
        }
    }
}

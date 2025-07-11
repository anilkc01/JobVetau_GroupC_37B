/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.companyData;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


/**
 *
 * @author thismac
 */
public class companyDashboard extends javax.swing.JFrame {
    /**
     * Creates new form companyDashboard
     */
    public companyDashboard() {
        initComponents();
        jobList.setLayout(new javax.swing.BoxLayout(jobList, javax.swing.BoxLayout.Y_AXIS));
        jobList.setPreferredSize(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        companyProfile = new javax.swing.JPanel();
        cmpLogo = new javax.swing.JLabel();
        cmpName = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        editCmpProfile = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cmpSector = new javax.swing.JTextField();
        cmpNo = new javax.swing.JTextField();
        cmpContact = new javax.swing.JTextField();
        cmpAddress = new javax.swing.JTextField();
        cmpEmail = new javax.swing.JTextField();
        cmpCEO = new javax.swing.JTextField();
        cmpEmpCount = new javax.swing.JTextField();
        cmpService = new javax.swing.JTextField();
        cmpWebsite = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addJob = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(161, 196, 247));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1087, 655));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Logo.png"))); // NOI18N
        Logo.setText("jLabel1");

        companyProfile.setBackground(new java.awt.Color(255, 255, 255));

        cmpLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/cmpLogo.png"))); // NOI18N
        cmpLogo.setFocusTraversalKeysEnabled(false);

        cmpName.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        cmpName.setText("Company Name");

        LogOut.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 51, 51));
        LogOut.setText("LogOut");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        editCmpProfile.setBackground(java.awt.Color.blue);
        editCmpProfile.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        editCmpProfile.setForeground(new java.awt.Color(102, 204, 0));
        editCmpProfile.setText("Edit");
        editCmpProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCmpProfileActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteBtn.setForeground(new java.awt.Color(153, 0, 0));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cmpSector.setEditable(false);
        cmpSector.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        cmpNo.setEditable(false);
        cmpNo.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cmpNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpNoActionPerformed(evt);
            }
        });

        cmpContact.setEditable(false);
        cmpContact.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        cmpAddress.setEditable(false);
        cmpAddress.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        cmpEmail.setEditable(false);
        cmpEmail.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cmpEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpEmailActionPerformed(evt);
            }
        });

        cmpCEO.setEditable(false);
        cmpCEO.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        cmpEmpCount.setEditable(false);
        cmpEmpCount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cmpEmpCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpEmpCountActionPerformed(evt);
            }
        });

        cmpService.setEditable(false);
        cmpService.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        cmpService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpServiceActionPerformed(evt);
            }
        });

        cmpWebsite.setEditable(false);
        cmpWebsite.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Company No. :");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setText("Sector :");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel3.setText("Contact :");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setText("Adddress :");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel5.setText("Email :");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel6.setText("Employees :");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel7.setText("CEO :");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel8.setText("Website");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel9.setText("Service");

        javax.swing.GroupLayout companyProfileLayout = new javax.swing.GroupLayout(companyProfile);
        companyProfile.setLayout(companyProfileLayout);
        companyProfileLayout.setHorizontalGroup(
            companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteBtn)
                .addContainerGap())
            .addGroup(companyProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmpNo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(cmpSector)
                    .addComponent(cmpAddress)
                    .addComponent(cmpContact)
                    .addComponent(cmpEmail)
                    .addComponent(cmpEmpCount)
                    .addComponent(cmpCEO)
                    .addComponent(cmpWebsite)
                    .addComponent(cmpService))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(companyProfileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmpLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpName)
                    .addComponent(LogOut)
                    .addComponent(editCmpProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        companyProfileLayout.setVerticalGroup(
            companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmpLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cmpName)
                .addGap(18, 18, 18)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpSector, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpEmpCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpCEO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmpService, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(editCmpProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(deleteBtn)
                .addContainerGap())
        );

        addJob.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addJob.setLabel("Add Job");

        jScrollPane1.setBackground(new java.awt.Color(161, 196, 247));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(675, 475));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(510, 200));
        jScrollPane1.setSize(new java.awt.Dimension(510, 200));

        jobList.setBackground(new java.awt.Color(161, 195, 247));
        jobList.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jobListLayout = new javax.swing.GroupLayout(jobList);
        jobList.setLayout(jobListLayout);
        jobListLayout.setHorizontalGroup(
            jobListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jobListLayout.setVerticalGroup(
            jobListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jobList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(companyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(addJob, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(companyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutActionPerformed

    private void editCmpProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCmpProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCmpProfileActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cmpEmpCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpEmpCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpEmpCountActionPerformed

    private void cmpEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpEmailActionPerformed

    private void cmpNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpNoActionPerformed

    private void cmpServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpServiceActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(companyDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(companyDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(companyDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(companyDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new companyDashboard(company).setVisible(true);
            }
        });
    }
*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel Logo;
    private java.awt.Button addJob;
    private javax.swing.JTextField cmpAddress;
    private javax.swing.JTextField cmpCEO;
    private javax.swing.JTextField cmpContact;
    private javax.swing.JTextField cmpEmail;
    private javax.swing.JTextField cmpEmpCount;
    private javax.swing.JLabel cmpLogo;
    private javax.swing.JLabel cmpName;
    private javax.swing.JTextField cmpNo;
    private javax.swing.JTextField cmpSector;
    private javax.swing.JTextField cmpService;
    private javax.swing.JTextField cmpWebsite;
    private javax.swing.JPanel companyProfile;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editCmpProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jobList;
    // End of variables declaration//GEN-END:variables
    
    public javax.swing.JLabel cmpLogo() { return cmpLogo; }
    public javax.swing.JLabel cmpName() { return cmpName; }
    public javax.swing.JTextField cmpAddress() { return cmpAddress; }
    public javax.swing.JTextField cmpCEO() { return cmpCEO; }
    public javax.swing.JTextField cmpContact() { return cmpContact; }
    public javax.swing.JTextField cmpEmail() { return cmpEmail; }
    public javax.swing.JTextField cmpEmpCount() { return cmpEmpCount; }
    public javax.swing.JTextField cmpNo() { return cmpNo; }
    public javax.swing.JTextField cmpSector() { return cmpSector; }
    public javax.swing.JTextField cmpService() { return cmpService; }
    public javax.swing.JTextField cmpWebsite() { return cmpWebsite; }
    public javax.swing.JPanel getPanel(){return jobList;}
    
    public javax.swing.JButton getEditBtn() {
        return editCmpProfile;
    }

    public void editListener(ActionListener listener) {
        editCmpProfile.addActionListener(listener);
    }
    
    public void logOutListener(ActionListener listener) {
        LogOut.addActionListener(listener);
    }
    
    public void logoClickListener(MouseAdapter listener) {
        cmpLogo.addMouseListener(listener);
    }
    
    public void deleteListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
    
    public void addJobListener(ActionListener listener) {
        addJob.addActionListener(listener);
    }
    
}

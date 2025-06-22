/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.userData;
import View.*;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class logInController {
    private final dao userDao = new dao();
    private final Login userView;

    public logInController(Login userView) {
        this.userView = userView;
        userView.addAddUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }
    
    class AddUserListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = userView.getuName();
                String password = userView.getPass();
                
                 if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Username is required.");
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Password is required.");
                    return;
                }
                userData user = userDao.logIn(username, password);
                if(user == null){
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                    return;
                }
                if(user.getRole().equals("seeker")){
                    SkrDashboard dashboard = new SkrDashboard();
                    skrController c = new skrController(dashboard,user.getId());
                    c.open();
                   

                }else if(user.getRole().equals("company")){ 
                    companyDashboard dashboard = new companyDashboard();
                    cmpController c = new cmpController(dashboard,user.getId());
                    c.open();
                    
                }else if(user.getRole().equals("admin")){
                    adminDashboard dashbaord = new adminDashboard();
                    adminDashboardController c = new adminDashboardController(dashbaord);
                    c.open();
                    
                }
                
                close();
            } catch (Exception ex) {
                System.out.println("Error Loggig user: " + ex.getMessage());
            }
        }
    }
    
}

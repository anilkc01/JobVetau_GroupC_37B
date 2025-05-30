/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.userData;
import View.Login;
import View.companyDashboard;
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
                    JOptionPane.showMessageDialog(null, "Username is required.");
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is required.");
                    return;
                }
                String role = userDao.checkUser(username);
                
                if(role.equals("null")){
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }else if(role.equals("company")){
                    
                    companyDashboard dashboard = new companyDashboard();
                    cmpController c = new cmpController(dashboard,userDao.logIn(username, password));
                    c.getSetValues();
                    c.open();
                
                }
                
                
            } catch (Exception ex) {
                System.out.println("Error Loggig user: " + ex.getMessage());
            }
        }
    }
    
}

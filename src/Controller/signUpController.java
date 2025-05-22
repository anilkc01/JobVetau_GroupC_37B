/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.userData;
import View.Registration;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class signUpController {
     private final dao userDao = new dao();
    private final Registration userView;

    public signUpController(Registration userView) {
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
                String name = userView.getName();
                String username = userView.getuName();
                String email = userView.getEmail();
                String number = userView.getNumber();
                String address = userView.getAddress();
                String role = userView.getRole();
                String password = userView.getPassword();
                
                userData user = new userData(name,username,number,email,address,role, password);
                boolean check = userDao.checkUser(user);
                if (check) {
                    JOptionPane.showMessageDialog(userView, "Duplicate user");
                } else {
                    userDao.signUp(user);
                }
            } catch (Exception ex) {
                System.out.println("Error adding user: " + ex.getMessage());
            }
        }
    }
    
}

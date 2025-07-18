package Controller;

import Model.companyData;
import Model.userData;
import View.Login;
import View.Registration;
import View.companyDashboard;
import dao.dao;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class signUpController {
    private final dao userDao = new dao();
    private final Registration userView;

    public signUpController(Registration userView) {
        this.userView = userView;
        userView.AddUserListener(new AddUserListener());
        
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

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Name is required");
                    return;
                }
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Username is required.");
                    return;
                }
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Email is required.");
                    return;
                }
                if (number.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Phone number is required.");
                    return;
                }
                if (address.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Address is required.");
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Password is required.");
                    return;
                }
                if (password.equals("mismatch")) {
                    JOptionPane.showMessageDialog(userView, "Passwords do not match.");
                    return;
                }
                if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    JOptionPane.showMessageDialog(userView, "Invalid email format.");
                    return;
                }
                if (!number.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(userView, "Phone number must be 10 digits.");
                    return;
                }

              
                userData user = new userData(name, username, number, email, address, role, password);
                String check = userDao.checkUser(user.getUsername());
                if (!check.equals("null")) {
                    JOptionPane.showMessageDialog(userView, "Duplicate User");
                    return;
                }else{
                    
                    if(userDao.signUp(user)){
                        Login loginPage = new Login();
                        logInController c = new logInController(loginPage);
                        c.open();
                        close();
                    }else{}
                    
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
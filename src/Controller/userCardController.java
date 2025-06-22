/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.userCard;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class userCardController {
    private userCard card;
    private int id;
    private String imagePath;
    private String name;
    private String phone;
    private String email; 
    private String address;
    
    public userCardController(userCard card,int id,String imagePath,String name, String phone,String email, String address){
        this.card = card;
        this.id = id;
        this.imagePath = imagePath;;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.card.deleteListener(new delteUser());
        SetValues();
    }
    
    public void open() {
       
        this.card.setVisible(true);
    }
    
      public void close() {
        this.card.setVisible(false);
    }
    
    
    public void SetValues(){
        
        card.Name.setText(this.name);
        card.number.setText(this.phone);
        card.email.setText(this.email);
        card.address.setText(this.address);
        String path =imagePath;
        if (path != null && !path.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(path);
                card.dp.setIcon(icon);
            } catch (Exception e) {
                card.dp.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
            }
        } else {
            card.dp.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
        }
    }

    private class delteUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(
                        card,
                        "Are you sure you want to delete?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

             if (response == JOptionPane.YES_OPTION) {
                dao uDao = new dao();
                uDao.deleteUser(id);
                close();
            }

        }

    }
    
}

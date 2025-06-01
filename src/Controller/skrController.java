/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.seekerData;
import View.Login;
import View.SkrDashboard;
import View.companyDashboard;
import dao.dao;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author thismac
 */
public class skrController {
   private final dao  userDao =  new dao();
   private final SkrDashboard userView;
   private final int id;
   seekerData seeker = null;
   private static final String UPLOAD_DIR = "Assets";
   
   public skrController(SkrDashboard userView,int id) {
        this.userView = userView;
        this.id = id;
        userView.editListener(new editOrSave());
        userView.logOutListener(new logOut());
        userView.logoClickListener(new logoClick());
        userView.deleteListener(new delete());
         new File(UPLOAD_DIR).mkdirs();
        getSetValues();
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }
    
    public void getSetValues() {

        seeker = userDao.getSeekerData(id);
        
        userView.skrName().setText(seeker.getName());
        userView.skrID().setText(seeker.getIdNo());
        userView.skrContact().setText(seeker.getNumber());
        userView.skrEmail().setText(seeker.getEmail());
        userView.skrAddress().setText(seeker.getAddress());
        userView.skrDOB().setText(seeker.getDOB());
        userView.skrExperience().setText(seeker.getExperience());
        userView.skrSpecialization().setText(seeker.getSpecialization());
        userView.skrPortfolio().setText(seeker.getProtfolio());
        
        String path = seeker.getPhoto();
        if (path != null && !path.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(path);
                userView.skrImage().setIcon(icon);
            } catch (Exception e) {
                userView.skrImage().setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
            }
        } else {
            userView.skrImage().setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
        }
    }
    
    
    private static class logOut implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Login loginPage = new Login();
            logInController c = new logInController(loginPage);
            c.open();
        }
    }

    private class delete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredPassword = JOptionPane.showInputDialog(
                    null,
                    "Enter your password to confirm deletion:",
                    "Confirm Deletion",
                    JOptionPane.WARNING_MESSAGE
            );

            if (enteredPassword != null) {
                if (enteredPassword.equals(seeker.getPassword())) { 
                    userDao.deleteUser(id);
                    Login registerForm = new Login();
                    logInController c = new logInController(registerForm);
                    c.open();
                    close();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password. Deletion canceled.");
                }
            }

        }

    }



        
    private class logoClick extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (userView.skrImage().isEnabled()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg"));
                int result = fileChooser.showOpenDialog(userView);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String previous = seeker.getPhoto();
                    try {
                       BufferedImage originalImage = ImageIO.read(selectedFile);
                       BufferedImage resizedImage = resizeImage(originalImage, 80, 80);
                        

                        String fileName = id +"_"+selectedFile.getName()+".png";
                        Path destination = Paths.get(UPLOAD_DIR, fileName);
                        File outputFile = destination.toFile();
                        ImageIO.write(resizedImage, "png", outputFile);
                        seeker.setPhoto(destination.toString());
                        ImageIcon icon = new ImageIcon(destination.toString());
                        userView.skrImage().setIcon(icon);
                        
                        if(previous != null){
                             File existingLogo = new File(previous);
                             existingLogo.delete();
                        }
                        
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error uploading logo: " + ex.getMessage());
                    }
                }
            }
        }
            private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
            // Scale image to 80x80 while preserving aspect ratio
            Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
            resizedImage.getGraphics().drawImage(scaledImage, 0, 0, null);
            return resizedImage;
        }
    }
    
        private class editOrSave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pLabel = userView.getEditBtn().getText();
                if(pLabel.equals("Edit")){
                    userView.getEditBtn().setText("Save");
                    setEditable(true);
                }else{
                    userView.getEditBtn().setText("Edit");
                    setEditable(false);
                    seeker.setIdNo(userView.skrID().getText());
                    seeker.setNumber(userView.skrContact().getText());
                    seeker.setEmail(userView.skrEmail().getText());
                    seeker.setAddress(userView.skrAddress().getText());
                    System.out.println(userView.skrDOB().getText());
                    System.out.println(userView.skrDOB().getText().trim());
                    seeker.setDOB(userView.skrDOB().getText().equals("    -  -  ")? null:userView.skrDOB().getText());
                    seeker.setExperience(userView.skrExperience().getText());
                    seeker.setSpecialization(userView.skrSpecialization().getText());
                    seeker.setProtfolio(userView.skrPortfolio().getText());
                   userDao.updateSeeker(seeker);
                    getSetValues();
                    

                }
        }
    }
        
    private void setEditable(boolean editable) {
        userView.skrID().setEditable(editable);
        userView.skrContact().setEditable(editable);
        userView.skrEmail().setEditable(editable);
        userView.skrAddress().setEditable(editable);
        userView.skrDOB().setEditable(editable);
        userView.skrExperience().setEditable(editable);
        userView.skrSpecialization().setEditable(editable);
        userView.skrPortfolio().setEditable(editable);
        
        
    }
}

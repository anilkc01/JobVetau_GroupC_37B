/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.companyData;
import Model.jobData;
import Model.userData;
import View.*;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.lang.System.Logger.Level;
import javax.swing.JFrame;

/**
 *
 * @author thismac
 */
public class cmpController {
   private final dao  userDao =  new dao();
   private final companyDashboard userView;
   private final int id;
   companyData company = null;
   private static final String UPLOAD_DIR = "Assets";
   private static final int LOGO_SIZE = 80;


    public cmpController(companyDashboard userView, int id) {
        this.userView = userView;
        this.id = id;
        userView.editListener(new editOrSave());
        userView.logOutListener(new logOut());
        userView.logoClickListener(new logoClick());
        userView.deleteListener(new delete());
        userView.addJobListener(new addNewJob());
        new File(UPLOAD_DIR).mkdirs();
        getSetValues();
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }
    
    public void getSetValues(){
        
        company  = userDao.getCompanyData(id);
        
        userView.cmpName().setText(company.getName());
        userView.cmpNo().setText(company.getRegNo());
        userView.cmpSector().setText(company.getSector());
        userView.cmpAddress().setText(company.getAddress());
        userView.cmpContact().setText(company.getNumber());
        userView.cmpEmail().setText(company.getEmail());
        userView.cmpCEO().setText(company.getCeo());
        userView.cmpEmpCount().setText(Integer.toString(company.getEmployees()));
        userView.cmpWebsite().setText( company.getWebsite());
        userView.cmpService().setText(company.getService());
        String path = company.getPhoto();
        if (path != null && !path.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(path);
                userView.cmpLogo().setIcon(icon);
            } catch (Exception e) {
                userView.cmpLogo().setIcon(new ImageIcon(getClass().getResource("/Assets/cmpLogo.png")));
            }
        } else {
           userView. cmpLogo().setIcon(new ImageIcon(getClass().getResource("/Assets/cmpLogo.png")));
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

    private class addNewJob implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             addJob jobForm = new addJob();

            int result = JOptionPane.showConfirmDialog(
                    null,
                    jobForm,
                    "Add New Job",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                String title = jobForm.getTitle();
                String description = jobForm.getDescription();
                String mode = jobForm.getMode();
                String location = jobForm.getJobLocation();
                String salary = jobForm.getSalary();

                // Validate inputs here (optional)
                // Save to DB using DAO
                jobData newJob = new jobData(title,description,location,salary,mode,id);
                userDao.addJob(newJob);

                JOptionPane.showMessageDialog(null, "Job added successfully!");
            }

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
                if (enteredPassword.equals(company.getPassword())) { 
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
                    company.setRegNo(userView.cmpNo().getText());
                    company.setSector(userView.cmpSector().getText());
                    company.setAddress(userView.cmpAddress().getText());
                    company.setNumber(userView.cmpContact().getText());
                    company.setEmail(userView.cmpEmail().getText());
                    company.setCeo(userView.cmpCEO().getText());
                    company.setEmployees(Integer.parseInt(userView.cmpEmpCount().getText()));
                    company.setWebsite(userView.cmpWebsite().getText());
                    company.setService(userView.cmpService().getText());
                    userDao.updateCompany(company);
                    getSetValues();
                    

                }
        }
    }
    
    private class logoClick extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (userView.cmpLogo().isEnabled()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg"));
                int result = fileChooser.showOpenDialog(userView);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String previous = company.getPhoto();
                    try {
                       BufferedImage originalImage = ImageIO.read(selectedFile);
                       BufferedImage resizedImage = resizeImage(originalImage, 80, 80);
                        

                        String fileName = id +"_"+selectedFile.getName()+".png";
                        Path destination = Paths.get(UPLOAD_DIR, fileName);
                        File outputFile = destination.toFile();
                        ImageIO.write(resizedImage, "png", outputFile);
                        company.setPhoto(destination.toString());
                        ImageIcon icon = new ImageIcon(destination.toString());
                        userView.cmpLogo().setIcon(icon);
                        
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
    
    private void setEditable(boolean editable) {
        
        userView.cmpAddress().setEditable(editable);
        userView.cmpCEO().setEditable(editable);
        userView.cmpEmail().setEditable(editable);
        userView.cmpEmpCount().setEditable(editable);
        userView.cmpContact().setEditable(editable);
        userView.cmpNo().setEditable(editable);
        userView.cmpSector().setEditable(editable);
        userView.cmpService().setEditable(editable);
        userView.cmpWebsite().setEditable(editable);
    }
    
   

    
}

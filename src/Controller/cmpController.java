/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.companyData;
import Model.userData;
import View.Login;
import View.companyDashboard;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author thismac
 */
public class cmpController {
   private final dao  userDao =  new dao();
   private final companyDashboard userView;
   private final int id;
   companyData company = null;

    public cmpController(companyDashboard userView, int id) {
        this.userView = userView;
        this.id = id;
        userView.editListener(new editOrSave());
        userView.logOutListener(new logOut());
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
    }

    private static class logOut implements ActionListener {

        

        @Override
        public void actionPerformed(ActionEvent e) {
            Login loginPage = new Login();
            logInController c = new logInController(loginPage);
            c.open();
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

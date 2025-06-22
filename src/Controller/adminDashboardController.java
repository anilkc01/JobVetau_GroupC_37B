/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.adminDashboard;
import View.jobItem;
import View.ourJobs;
import View.userCard;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;


/**
 *
 * @author thismac
 */
public class adminDashboardController {
    private final dao uDao = new dao();
    private final adminDashboard dashboard;
    private ArrayList<companyData> companies = null;
    private ArrayList<seekerData> seekers = null;
    private ArrayList<jobData> jobs = null;
     public javax.swing.JPanel itemContainer;
    
    
    
    public adminDashboardController(adminDashboard dashboard){
        this.dashboard = dashboard;
        this.dashboard.companyBtnListener(new showCompanies());
        this.dashboard.seekerBtnListener(new showSeekers());
        this.dashboard.jobBtnListener(new showJobs());
        getSetCompanies();
        
    }
    
    public void open(){
        this.dashboard.setVisible(true);
    }
    
    public void close(){
        this.dashboard.setVisible(false);
    }
    
    public void getSetCompanies(){
        companies = uDao.getAllCompanies();
        itemContainer = dashboard.listView;
        itemContainer.removeAll();

        for (companyData company : companies) {
            System.out.println(company.getName());
            userCard card = new userCard();
            new userCardController(card, company.getId(),company.getPhoto(),company.getName(),company.getNumber(),company.getEmail(),company.getAddress());
            itemContainer.add(card);
            itemContainer.add(Box.createVerticalStrut(10));
        }

        itemContainer.revalidate();
        itemContainer.repaint();
        
        dashboard.cmpBtn.setEnabled(false);
        dashboard.srkBtn.setEnabled(true);
        dashboard.jobsBtn.setEnabled(true);
    
    }
    
    public void getSetSeekers(){
        seekers = uDao.getAllSeekers();
        itemContainer = dashboard.listView;
        itemContainer.removeAll();

        for (seekerData seeker : seekers) {
            System.out.println(seeker.getName());
            userCard card = new userCard();
            new userCardController(card, seeker.getId(),seeker.getPhoto(),seeker.getName(),seeker.getNumber(),seeker.getEmail(),seeker.getAddress());
            itemContainer.add(card);
            itemContainer.add(Box.createVerticalStrut(10));
        }

        itemContainer.revalidate();
        itemContainer.repaint();
        dashboard.cmpBtn.setEnabled(true);
        dashboard.srkBtn.setEnabled(false);
        dashboard.jobsBtn.setEnabled(true);
        
    
    }
    
    public void getSetJobs(){
        jobs = uDao.getAllJobs();
        itemContainer = dashboard.listView;
        itemContainer.removeAll();

        for (jobData job : jobs) {
            ourJobs jobPanel = new ourJobs();
            ourJobController c = new ourJobController(jobPanel, job);
            c.admin();
            itemContainer.add(jobPanel);
            itemContainer.add(Box.createVerticalStrut(10));
        }

        itemContainer.revalidate();
        itemContainer.repaint();
        dashboard.cmpBtn.setEnabled(true);
        dashboard.srkBtn.setEnabled(true);
        dashboard.jobsBtn.setEnabled(false);
    }
        
     

    private class showJobs implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           getSetJobs();
        }

    }

    private class showSeekers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           getSetSeekers();
        }

    }

    private class showCompanies implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           getSetCompanies();
        }
        
    }
    
}

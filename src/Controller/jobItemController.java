/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class jobItemController {
    private final dao uDao = new dao();
    private final jobItem jobView;
    private jobData job;
            
    public jobItemController(jobItem jobView, jobData job){
        this.jobView = jobView;
        this.job = job;
        getSetJobs();
        
    }
    public void open() {
        this.jobView.setVisible(true);
    }
    
      public void close() {
        this.jobView.setVisible(false);
    }
    
    public void getSetJobs(){
       
        jobView.Title.setText(job.getTitle());
        jobView.Description.setText(job.getDescription());
        jobView.Date.setText(job.getPostedDate());
        jobView.Location.setText(job.getLocation());
        jobView.Mode.setText(job.getMode());
        jobView.cmpName.setText(job.getCompanyName());
        jobView.Salary.setText(job.getSalary());
        
    }

}

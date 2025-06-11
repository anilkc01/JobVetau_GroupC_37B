/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import dao.dao;
import java.awt.Color;
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
    private appliedJobData job;
    private int  skrID;
            
    public jobItemController(jobItem jobView, appliedJobData job,int skrID){
        this.jobView = jobView;
        this.job = job;
        this.skrID= skrID;
        jobView.listenApply(new applyWithdraw());
        getSetJobs();
        
    }
    public void open() {
        this.jobView.setVisible(true);
    }
    
      public void close() {
        this.jobView.setVisible(false);
    }
    
    public void getSetJobs(){
        if(job.getStatus().equals("Pending")){
           jobView.Status.setForeground(Color.YELLOW);
           jobView.apply.setText("Withdraw");
           jobView.apply.setForeground(Color.RED);
        }
        else if(job.getStatus().equals("Accepted")){
            jobView.Status.setForeground(Color.GREEN);
             jobView.apply.setVisible(false);
        }
        else if(job.getStatus().equals("Rejected")){
            jobView.Status.setForeground(Color.RED);
            jobView.apply.setVisible(false);
        }else{
             jobView.Status.setVisible(false);
        }
                
       jobView.Status.setText(job.getStatus());
        jobView.Title.setText(job.getTitle());
        jobView.Description.setText(job.getDescription());
        jobView.Date.setText(job.getPostedDate());
        jobView.Location.setText(job.getLocation());
        jobView.Mode.setText(job.getMode());
        jobView.cmpName.setText(job.getCompanyName());
        jobView.Salary.setText(job.getSalary());
        
    }

    private  class applyWithdraw implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(jobView.apply.getText().equals("Apply")){
                applicationData newApplication = new applicationData(skrID,job.getId(),"Pending");
                if(uDao.addApplication(newApplication)){
                    JOptionPane.showMessageDialog(jobView, "Applied Successfully !");
                    close();
                }else{
                    JOptionPane.showMessageDialog(jobView, "Application Failed !");
                }
            }else{
                if(uDao.withdrawApplication(skrID, job.getId())){
                     JOptionPane.showMessageDialog(jobView, "Withdrawn!");
                     
                     close();
                }else{
                     JOptionPane.showMessageDialog(jobView, "Failed to withdraw!");
                }
            
            }
        }

     
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.jobData;
import View.ourJobs;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public final class ourJobController {
    private final dao uDao = new dao();
    private final ourJobs jobView;
    private final jobData job;
            
    public ourJobController(ourJobs jobView, jobData job){
        this.jobView = jobView;
        this.job = job;
        getSetJobs();
        jobView.deleteJobListener(new deleteJob());
        
    }
    public void open() {
        this.jobView.setVisible(true);
    }
    
      public void close() {
        this.jobView.setVisible(false);
    }
    
    public void getSetJobs(){
        System.out.println("Setting job: " + job.getTitle());
        jobView.Title().setText(job.getTitle());
        System.out.println("Setting job: " + job.getDescription());
        jobView.Description().setText(job.getDescription());
        jobView.Mode().setText(job.getMode());
        jobView.Salary().setText(job.getSalary());
        jobView.Location().setText(job.getLocation());
        
    }

    private class deleteJob implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           if(uDao.deleteJob(job.getId())){
               JOptionPane.showMessageDialog(null, "Job Deleted ");
               close();
           }else{
               JOptionPane.showMessageDialog(null, "Could not delete job");
           }
        }

    }
}

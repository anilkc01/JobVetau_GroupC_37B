/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.jobData;
import View.Applications;
import View.ourJobs;
import dao.dao;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author thismac
 */
public class ourJobController {
    private final dao uDao = new dao();
    private final ourJobs jobView;
    private jobData job;
            
    public ourJobController(ourJobs jobView, jobData job){
        this.jobView = jobView;
        this.job = job;
        getSetJobs();
        this.jobView.deleteJobListener(new deleteJob());
        this.jobView.showApplications(new showApplications());
        
    }
    
    public void admin(){
        this.jobView.cmpName.setVisible(true);
        this.jobView.viewApplications.setVisible(false);
     
    }
    public void company(){
        this.jobView.cmpName.setVisible(false);
        this.jobView.viewApplications.setVisible(true);
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
        jobView.cmpName.setText(job.getCompanyName());
        System.out.println("Setting job: " + job.getDescription());
        jobView.Description().setText(job.getDescription());
        jobView.Mode().setText(job.getMode());
        jobView.Salary().setText(job.getSalary());
        jobView.Location().setText(job.getLocation());
        
    }

    private  class showApplications implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
        Applications applicationsPanel = new Applications();
        ApplicationsController controller = new ApplicationsController(applicationsPanel,job.getId()); 

        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(jobView);

        // Create a modal dialog with Applications panel
        JDialog dialog = new JDialog((Frame) parentWindow, "Applicants for: " + job.getTitle(), true); // modal

        dialog.getContentPane().add(applicationsPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(parentWindow); // center on parent
        dialog.setVisible(true);
        }
        
    }

    private class deleteJob implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(
                        jobView,
                        "Are you sure you want to delete?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

            if (response == JOptionPane.YES_OPTION) {
                if (uDao.deleteJob(job.getId())) {
                    JOptionPane.showMessageDialog(null, "Job Deleted ");
                    close();
                } else {
                    JOptionPane.showMessageDialog(null, "Could not delete job");
                }
            }

        }

    }
}

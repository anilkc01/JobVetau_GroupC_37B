/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.jobData;
import View.ourJobs;
import dao.dao;

/**
 *
 * @author thismac
 */
public class ourJobController {
    private final dao uDao = new dao();
    private final ourJobs jobView;
    private int uid;
    private jobData job;
            
    public ourJobController(ourJobs jobView, jobData job){
        this.jobView = jobView;
        this.job = job;
        getSetJobs();
        this.jobView.setVisible(true);
        
    }
    public void open() {
        this.jobView.setVisible(true);
    }
    
    public void getSetJobs(){
        jobView.Title().setText(job.getTitle());
        jobView.Description().setText(job.getDescription());
        jobView.Mode().setText(job.getMode());
        jobView.Salary().setText(job.getSalary());
        jobView.Location().setText(job.getLocation());
        
    }
}

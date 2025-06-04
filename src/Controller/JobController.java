package Controller;

import dao.JobDAO;
import Model.Job;
import View.viewjobpage;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JobController {
    private JobDAO jobDAO;
    private viewjobpage view;
    
    public JobController(viewjobpage view) {
        this.jobDAO = new JobDAO();
        this.view = view;
    }
    
    public void loadJobsToTable() {
        List<Job> jobs = jobDAO.getAllJobs();
        DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
        
        // Clear existing rows
        model.setRowCount(0);
        
        // Add jobs to table
        for (Job job : jobs) {
            Object[] row = {
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary(),
                job.getPostDate(),
                job.getCompanyId()
            };
            model.addRow(row);
        }
    }
    
    public void showJobsView() {
        loadJobsToTable();
        view.setVisible(true);
    }
} 
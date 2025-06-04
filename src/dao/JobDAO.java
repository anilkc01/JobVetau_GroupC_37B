package dao;

import Model.Job;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private List<Job> jobs;
    
    public JobDAO() {
        jobs = new ArrayList<>();
        initializeSampleJobs();
    }
    
    private void initializeSampleJobs() {
        // Add sample jobs
        jobs.add(new Job(1, "Senior Software Engineer", 
            "Lead development of enterprise applications using Java and Spring Boot. Must have 5+ years experience.",
            "New York, NY", 120000.0f, "2024-03-15", 101));
            
        jobs.add(new Job(2, "Data Scientist", 
            "Analyze large datasets and create ML models for business insights. Experience with Python and TensorFlow required.",
            "San Francisco, CA", 135000.0f, "2024-03-14", 102));
            
        jobs.add(new Job(3, "UX/UI Designer", 
            "Create intuitive user interfaces for web and mobile applications. Proficient in Figma and Adobe Creative Suite.",
            "Austin, TX", 95000.0f, "2024-03-14", 103));
            
        jobs.add(new Job(4, "DevOps Engineer", 
            "Manage cloud infrastructure and implement CI/CD pipelines. AWS certification preferred.",
            "Seattle, WA", 115000.0f, "2024-03-13", 104));
            
        jobs.add(new Job(5, "Product Manager", 
            "Lead product development and coordinate with stakeholders. MBA or equivalent experience required.",
            "Boston, MA", 125000.0f, "2024-03-13", 105));
    }
    
    public List<Job> getAllJobs() {
        return jobs;
    }
    
    public Job getJobById(int id) {
        return jobs.stream()
                  .filter(job -> job.getId() == id)
                  .findFirst()
                  .orElse(null);
    }
} 
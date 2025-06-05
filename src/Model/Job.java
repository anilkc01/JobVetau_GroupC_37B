package Model;

public class Job {
    private int id;
    private String title;
    private String description;
    private String location;
    private double salary;
    private String postDate;
    private int companyId;
    
    public Job(int id, String title, String description, String location, double salary, String postDate, int companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.postDate = postDate;
        this.companyId = companyId;
    }
    
    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public double getSalary() { return salary; }
    public String getPostDate() { return postDate; }
    public int getCompanyId() { return companyId; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setPostDate(String postDate) { this.postDate = postDate; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
} 
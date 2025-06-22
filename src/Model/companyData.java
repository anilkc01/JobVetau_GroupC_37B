package Model;

/**
 *
 * @author thismac
 */
public class companyData extends userData {
    private String photo; 
    private String sector; 
    private int employees; 
    private String ceo; 
    private String website; 
    private String service;
    private String regNo;

    public companyData(String name, String username, String number, String email, String address, String role, 
                   String password, String photo, String sector, int employees, String ceo, 
                   String website, String service, String regNo) {
        super(name, username, number, email, address, role, password);
        this.photo = photo;
        this.sector = sector;
        this.employees = employees;
        this.ceo = ceo;
        this.website = website;
        this.service = service;
        this.regNo = regNo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    
}
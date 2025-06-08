/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author thismac
 */
public class appliedJobData extends jobData {
    private String status;

    public appliedJobData(String title, String description, String location, String salary, String mode, String status) {
        super(title, description, location, salary, mode);
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
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
public class seekerData extends userData{
    private  String photo;
    private String idNo;
    private String DOB;
    private String experience;
    private String specialization;
    private String protfolio;

    public seekerData(String photo, String idNo, String DOB, String experience, String specialization, String protfolio, String name, String username, String number, String email, String address, String role, String password) {
        super(name, username, number, email, address, role, password);
        this.photo = photo;
        this.idNo = idNo;
        this.DOB = DOB;
        this.experience = experience;
        this.specialization = specialization;
        this.protfolio = protfolio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getProtfolio() {
        return protfolio;
    }

    public void setProtfolio(String protfolio) {
        this.protfolio = protfolio;
    }
    
    
    
}

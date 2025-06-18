/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class Applicant {
    
    private int sn;
    private String name;
    private String experience;

    public Applicant(int sn, String name, String experience) {
        this.sn = sn;
        this.name = name;
        this.experience = experience;
    }

    public int getSn() { return sn; }
    public String getName() { return name; }
    public String getExperience() { return experience; }

    public void setSn(int sn) { this.sn = sn; }
    public void setName(String name) { this.name = name; }
    public void setExperience(String experience) { this.experience = experience; }
}

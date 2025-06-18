/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.List;

public class ApplicantData {
    public static List<Applicant> getDummyData() {
        return List.of(
            new Applicant(1, "Pratyush", "2 Years"),
            new Applicant(2, "Suman", "3 Years"),
            new Applicant(3, "Bikash", "1 Year")
        );
    }
}


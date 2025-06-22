/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobvetau_groupc_37b;

import Controller.*;
import Database.*;
import View.*;

/**
 *
 * @author thismac
 */
public class JobVetau_GroupC_37B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*adminDashboard d = new adminDashboard();
        adminDashboardController c = new adminDashboardController(d);
        c.open();
        
        */
       
        Login registerForm = new Login();
        logInController c = new logInController(registerForm);
        c.open();



    }
    
}

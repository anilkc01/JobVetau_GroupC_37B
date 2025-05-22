/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobvetau_groupc_37b;

import Controller.signUpController;
import Database.*;
import View.Registration;

/**
 *
 * @author thismac
 */
public class JobVetau_GroupC_37B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registration registerForm = new Registration();

        signUpController c = new signUpController(registerForm);
        c.open();
    }
    
}

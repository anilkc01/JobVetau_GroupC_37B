/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobvetau_groupc_37b;

import Database.*;

/**
 *
 * @author thismac
 */
public class JobVetau_GroupC_37B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        database db = new MySqlConnection();
        if(db.openConnection()!=null){
            System.out.println("Database Connected Successfully.");
        } else{
            System.out.println("Failes to connect to database.");
        }
    }
    
}

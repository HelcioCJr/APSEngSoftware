/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmoraqui;

import gui.Login;

/**
 *
 * @author Marcello
 */
public class AppMoraqui {

    /**
     * @param args the command line arguments
     */
    private static Login telaLogin = new Login();
    public static void main(String[] args) {
        telaLogin.setVisible(true);
        telaLogin.setEnabled(true);
        
    }
    
}

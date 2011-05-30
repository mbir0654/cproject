/**
 * 
 */
package test;

import javax.swing.*;
import client.RMIUtil;
import controller.Controller;

/**
 * @author otniel
 *
 */

public class GuiTester {
	/**
	 * 
	 * Date de incercare!!!!
	 * 
	 * admin - Username: adi Password: pass
	 * 
	 * student - Username: alex Password: pass
	 * 
	 * profesor - username: bobby Password pass 
	 * 
	 */
	
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	try {
    	    // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }

        Controller controllerLogin = new Controller(RMIUtil.getAppService());
        controllerLogin.openLoginFrame();
    }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



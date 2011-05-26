/**
 * 
 */
package test;

import javax.swing.*;
/*import java.awt.*;
import java.awt.event.*;*/
import controller.Controller;
import ui.*;

/**
 * @author otniel
 *
 */

public class GuiTester {
	
	
	
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

/*        Controller controlerLogin = new Controller()
        JFrame loginFrame = new FrameLogin();
        loginFrame.setVisible(true);
        loginFrame.setTitle("SEMS:: Login");
        loginFrame.setName("Login");
        loginFrame.pack();
        loginFrame.setResizable(false);*/
    }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



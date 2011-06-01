/**
 * 
 */
package controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;

import ui.FrameLogin;
import business.model.Administrator;
import business.model.Professor;
import business.model.Student;
import business.model.User;
import business.serviceinterface.InterfaceAppService;
import client.RMIUtil;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Aceasta clasa se va ocupa exclusiv de contolul ferestrelor si va face parte
 * din client in versiunea finala a aplicatiei
 * @author otniel
 *
 */
public class Controller {
	private User u;
	private FrameLogin loginFrame;
	private InterfaceAppService apps;
	
    /**
     * Constructor parametrizat
     * <p>atributul privat este referinta
     * spre interfata cu serviciile aplicatiei</p>
     *
     * @param service - serviciul utilizat de controller
     */

	public Controller(InterfaceAppService service){
        apps = service;
	}

    public void openLoginFrame() {
        List<Image> icons = new ArrayList<Image>();
        try {
            if (getClass().getResource("/icons/appico.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico.png")));
            }
            if (getClass().getResource("/icons/appico1.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico1.png")));
            }
            if (getClass().getResource("/icons/appico2.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico2.png")));
            }
            if (getClass().getResource("/icons/appico3.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico3.png")));
            }
            if (getClass().getResource("/icons/appico4.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico4.png")));
            }
            if (getClass().getResource("/icons/appico5.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico5.png")));
            }
            if (getClass().getResource("/icons/appico6.png") != null) {
                icons.add(ImageIO.read(getClass().getResource("/icons/appico6.png")));
            }
        } catch (IOException e) {
            System.out.println("Cannot load image");
            System.out.println(e.getMessage());
        }
        loginFrame = new FrameLogin(this);
        loginFrame.setIconImages(icons);
        loginFrame.setTitle("Login - SEMS");
        loginFrame.setName("Login");
        loginFrame.setResizable(false);
        //loginFrame.pack(); //daca faci pack, nu se mai vede labelul de eroare :-??
        loginFrame.setVisible(true);
    }
	
    /**
    * Checking the login username and password to know what to open
    */
    public void checkLogin() {
    	String inputUser = loginFrame.getInputUser().getText();
        String inputPassword = String.copyValueOf(
		loginFrame.getInputPass().getPassword());
        User user;
        try {
            user = login(inputUser, inputPassword);
            /*
             * Trimite username-ul si parola in format MD5
             * spre verificare la server
            */
            if(user instanceof Administrator) {
                ControllerAdmin controllerAdmin = new ControllerAdmin((Administrator) user, RMIUtil.getAdminService());
                controllerAdmin.openAdminFrame();
                loginFrame.setVisible(false);
            }
            else if(user instanceof Professor) {
                ControllerProfesor controllerProfesor = new ControllerProfesor((Professor) user, RMIUtil.getProfService());
                controllerProfesor.openProfesorFrame();
                loginFrame.setVisible(false);
            }
            else if(user instanceof Student) {
                ControllerStudent controllerStudent = new ControllerStudent((Student) user, RMIUtil.getStudentService());
                controllerStudent.openStudentFrame();
                loginFrame.setVisible(false);
            }
            else {
                loginFrame.getInfoText().setText("User sau parola gresite!!!");
                loginFrame.getInfoText().setVisible(true);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

	private User login(String username, String password) throws NoSuchAlgorithmException{
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = password.getBytes();
            m.update(data,0,data.length);
            BigInteger i = new BigInteger(1,m.digest());
            String pas = String.format("%1$032X", i);
            //System.out.println(pas);
            u = apps.ValidateUser(username, pas);
            return u;
	}


}

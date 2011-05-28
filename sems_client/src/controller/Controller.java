/**
 * 
 */
package controller;

import business.model.Administrator;
import business.model.Professor;
import business.model.Student;
import business.model.User;
import javax.swing.JFrame;

import java.math.BigInteger;
import java.security.*;

import business.serviceinterface.InterfaceAppService;
import client.RMIUtil;
import ui.*;
//import business.service.AppService;

/**
 * Aceasta clasa se va ocupa exclusiv de contolul ferestrelor si va face parte
 * din client in versiunea finala a aplicatiei
 * @author otniel
 *
 */
public class Controller {
	@SuppressWarnings("unused")

	private User u;
	private FrameLogin loginFrame;
	private InterfaceAppService apps;
	
	/**
	 * Constructorul implicit. 
	 * <p>atributul privat este referinta 
	 * spre clasa cu serviciile aplicatiei</p>
	 */

    /**
     *
     * @param service - serviciul utilizat de controller
     */

	public Controller(InterfaceAppService service){
        apps = service;
	}

    public void openLoginFrame() {
        loginFrame = new FrameLogin(this);
        loginFrame.setTitle("SEMS:: Login");
        loginFrame.setName("Login");
        loginFrame.setResizable(false);
        //loginFrame.pack(); //daca faci pack, nu se mai vede labelul de eroare :-??
        loginFrame.setVisible(true);
    }
	
    /**
     * @see InterfaceAppService#ValidateUser(String, String)
     * 
     * @param u este username-ul
     * @param p este parola 
     * @return referinta la user daca exista in baza de date
     */
	public User ValidateUser(String u, String p){
            System.out.println(apps.ValidateUser(u, p));
            return apps.ValidateUser(u, p);
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
                this.loginProf(loginFrame,(Professor) user);
                loginFrame.setVisible(false);
            }
            else if(user instanceof Student) {
                this.loginStudent(loginFrame,(Student) user);
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

	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginStudent(JFrame f,Student stud){
        u = new Student(stud);
        ControllerStudent cs = new ControllerStudent((Student) u, RMIUtil.getStudentService());
        cs.openMainFrame();

	}

        
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginProf(JFrame f, Professor P){
        u = new Professor(P);
        ControllerProfesor cp = new ControllerProfesor((Professor) u, RMIUtil.getProfService());
        JFrame profFrame = new FrameProfMain(cp);
        profFrame.setVisible(true);
        profFrame.setResizable(false);
        profFrame.setTitle("SEMS :: Profesor");
        //f.setVisible(false); //lasa linia asta comentata!!!
	}

	
	public User login(String username, String password) throws NoSuchAlgorithmException{
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = password.getBytes();
            m.update(data,0,data.length);
            BigInteger i = new BigInteger(1,m.digest());
            String pas = String.format("%1$032X", i);
            System.out.println(pas);
            u = ValidateUser(username, pas);
            return u;
	}


}

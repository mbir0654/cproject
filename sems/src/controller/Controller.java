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
import java.nio.charset.Charset;
import java.security.*;

import ui.*;
//import business.service.AppService;

/**
 * Aceasta clasa se va ocupa exclusiv de contolul ferestrelor si va face parte
 * din client in versiunea finala a aplicatiei
 * @author otniel
 *
 */
public class Controller {
	private User u;
	@SuppressWarnings("unused")
//	private AppService apps;
	
	/**
	 * Constructorul implicit. 
	 * <p>atributul privat este referinta 
	 * spre clasa cu serviciile aplicatiei</p>
	 * @see AppService#getInstance() 
	 */
	public Controller(){
//		apps = AppService.getInstance();
	}
	

	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */

        /*
         * Checking the login username and password to know what to open
         */
        public void checkLogin(frameLogin f) {
            String inputUser = f.getInputUser().getText();
            /*
             * Trimite username-ul si parola in format MD5
             * spre verificare la server
            */
            User U=new Student();
             System.out.println(U.getClass().toString());
            if(U.getClass().toString().contains("Administrator"))
                this.loginAdmin(f, (Administrator) U);
            else if(U.getClass().toString().contains("Professor"))
                this.loginProf(f,(Professor) U);
            else if(U.getClass().toString().contains("Student"))
                this.loginStudent(f,(Student) U);

        }

	public void loginAdmin(JFrame f,Administrator adm){
            u = new Administrator(adm);
            ControllerAdmin ca = new ControllerAdmin((Administrator) u);
		JFrame admin = new frameAdminMain(ca);
        admin.setVisible(true);
        admin.setTitle("SEMS :: Administrator");
        admin.setResizable(false);
        //f.setVisible(false); //lasa linia asta comentata!!!
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginStudent(JFrame f,Student stud){
            u = new Student(stud);
            ControllerStudent cs = new ControllerStudent((Student)u);
            cs.openMainFrame();
	}

        
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginProf(JFrame f, Professor P){
            u = new Professor(P);
            ControllerProfesor cp = new ControllerProfesor((Professor) u);
            JFrame prof = new frameProfMain(cp);
            prof.setVisible(true);
            prof.setTitle("SEMS :: Profesor");
            prof.setResizable(false);
            //f.setVisible(false); //lasa linia asta comentata!!!
	}
	
	
	public User login(String username, String password){
	    
		MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] data = password.getBytes(); 
        m.update(data,0,data.length);
        BigInteger i = new BigInteger(1,m.digest());
        String pas = String.format("%1$032X", i);
	
		u = ValidateUser(username, pas);
		
		return u;
	}


}

/**
 * 
 */
package controller;

import business.model.Professor;
import business.model.Student;
import business.model.User;
import javax.swing.JFrame;

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
	public void loginAdmin(JFrame f){
		JFrame admin = new frameAdminMain();
        admin.setVisible(true);
        admin.setTitle("SEMS :: Administrator");
        admin.setResizable(false);
        //f.setVisible(false); //lasa linia asta comentata!!!
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginStudent(JFrame f){
            u = new Student();
            ControllerStudent cs = new ControllerStudent((Student)u);
		JFrame student = new frameStudMain(cs);
        student.setVisible(true);
        student.setTitle("SEMS :: Administrator");
        student.setResizable(false);

        //f.setVisible(false); //lasa linia asta comentata!!!
	}

        
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginProf(JFrame f){
            u = new Professor();
            ControllerProfesor cp = new ControllerProfesor((Professor) u);
		JFrame prof = new frameProfMain(cp);
        prof.setVisible(true);
        prof.setTitle("SEMS :: Profesor");
        prof.setResizable(false);
        //f.setVisible(false); //lasa linia asta comentata!!!
	}


}

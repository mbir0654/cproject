/**
 * 
 */
package controller;

import javax.swing.JFrame;

import ui.*;
import business.service.AppService;

/**
 * Aceasta clasa se va ocupa exclusiv de contolul ferestrelor si va face parte
 * din client in versiunea finala a aplicatiei
 * @author otniel
 *
 */
public class Controller {
	
	@SuppressWarnings("unused")
	private AppService apps;
	
	/**
	 * Constructorul implicit. 
	 * <p>atributul privat este referinta 
	 * spre clasa cu serviciile aplicatiei</p>
	 * @see AppService#getInstance() 
	 */
	public Controller(){
		apps = AppService.getInstance();
	}
	
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void loginProf(JFrame f){
		JFrame prof = new frameProfMain();
        prof.setVisible(true);
        prof.setTitle("SEMS :: Profesor");
        prof.setResizable(false);
        //f.setVisible(false); //lasa linia asta comentata!!!
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
		JFrame student = new frameStudMain();
        student.setVisible(true);
        student.setTitle("SEMS :: Administrator");
        student.setResizable(false);
        //f.setVisible(false); //lasa linia asta comentata!!!
	}
	
	/**
	 * activeaza butoanele din form-ul de student, dupa selectarea unui curs
	 * 
	 * @param var este un boolean care arata daca butoanele sunt enabled
	 * 		  sau disabled: true, respectiv false
	 * 
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void setStudMainButtons(boolean var, frameStudMain f) {
        f.getButTrimiteTeme().setEnabled(var);
        f.getButMaterialeCurs().setEnabled(var);
        f.getButNote().setEnabled(var);

    }
	/**
	 * Deschide fereastra pentru gestionarea contractelor de studiu
	 */
	public void openContracts(){
		frameStudContracte contract = new frameStudContracte();
        contract.setTitle("SEMS :: Contracte");
        contract.setResizable(false);
        contract.getButContracteaza().setEnabled(false);
        contract.getPanouInfoCurs().setVisible(false);
        contract.setVisible(true);
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void enableContractButtons(frameStudContracte f){
		f.getButContracteaza().setEnabled(true);
		f.getPanouInfoCurs().setEnabled(true);
	}
	
	/**
	 * Deschide fereastra pentru gestionarea temelor si a rezolvarilor
	 * pentru cursul selectat
	 */
	public void openAssignments(){
		frameStudTeme teme = new frameStudTeme();
        teme.setVisible(true);
        teme.setTitle("SEMS :: Teme");
        teme.setResizable(false);
        teme.getLabelInfoTeme().setVisible(false);
        teme.getTemaDetalii().setEditable(false);
	}
	
	/**
	 * 
	 */
	public void enableAssignmentActions(frameStudTeme f){
		f.getLabelInfoTeme().setVisible(true);
	}
	
	/**
	 * Deschide fereastra pentru vizualizare/obtinere materiale pentru
	 *  cursul selectat
	 */
	public void openCourseComponents(){
		frameStudMaterialeCurs materiale = new frameStudMaterialeCurs();
        materiale.setVisible(true);
        materiale.setTitle("SEMS :: Materiale");
        materiale.setResizable(false);
        materiale.getMaterialText().setEditable(false);
        materiale.getMaterialInfo().setVisible(false);
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void showComponentInfo(frameStudMaterialeCurs f){
		f.getMaterialInfo().setVisible(true);
	}
	
	/**
	 * Deschide fereastra pentru vizualizare note la cursul selectat
	 */
	public void openGrades(){
		frameStudNote note = new frameStudNote();
        note.setVisible(true);
        note.setTitle("SEMS :: Note");
        note.setResizable(false);
        note.getListTeste().setVisible(false);
        note.getInfoTest().setVisible(false);
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void enableTestList(frameStudNote f){
		f.getListTeste().setVisible(true);
	}
	/**
	 * @param f este referinta spre fereastra afectata de metoda
	 */
	public void enableTestInfo(frameStudNote f){
		f.getInfoTest().setVisible(true);
	}
}

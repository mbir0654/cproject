/**
 * 
 */
package business.service;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JList;

import business.model.*;

/**
 * @author myh
 *
 */
final class StudentService {
	/**
	 * Studentul pentru care efectuam serviciile
	 */
	private Student s;
	public void viewCourses(){
		/**TODO
		 * incarca intr-un jlist disciplinele la care e inscris studentul 
		 */
	}
	public void exitSystem(){
		/**TODO
		 * logout user salveaza ce trebuie salvat in baza de date
		 */
	}
	public void viewAnnouncements(){
		/**TODO
		 * vizualizare anunturi pentru student s 
		 */
	}
	public void makeContract(){
		/**TODO
		 * load courses
		 * open makeContractDialog
		 */
	}
	public void loadAvailableCourses(JList list){
		/**TODO
		 * load available courses from db and reload a jlist  
		 */
	}
	public void loadCourseMaterials(JList list){
		/**TODO
		 * load materials from db and reload a jlist  
		 */
	}
	public void downloadCourseMaterial(/*CourseMaterial*/){
		/**TODO
		 * doanload selected course materials   
		 */
	}
	public void sendHomeWork(Disciplina d){
		/**TODO
		 * upload homework for course   
		 */
	}
	public void viewGrades(JList list){
		/**TODO
		 * load available grades from db and reload list  
		 */
	}
}

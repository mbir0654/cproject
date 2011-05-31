package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment implements Serializable {
	private String name = "";
	private String text = "";
	private Date deadline;
	private ArrayList<AssignmentSolution> solutions =
                new ArrayList<AssignmentSolution>();
	private Course course;
	
	/**
	 * Constructorul implicit
	 */
	public Assignment() {
	}
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param n este denumirea temei 
	 * 
	 * @param t este enuntul temei
	 * 
	 * @param d este data limita de predare a temei
	 * 
	 * @param c este cursul pt care e data tema
	 */
	public Assignment(String n, String t, Date d, Course c) {
		name = n;
		text = t;
		deadline = d;
		course = c;
	}
	
	/**
	 * Constructorul de copiere
	 * 
	 * @param a este tema care trebuie duplicata
	 */
	public Assignment(Assignment a){
		solutions = new ArrayList<AssignmentSolution>();
		solutions.addAll(a.getSolutions());
		name = a.name;
		deadline = a.deadline;
		text = a.text;
		course = a.course;
	}
	
	/**
	 * 
	 * @param r este rezolvarea care se adauga
	 */
	public void addSolution(AssignmentSolution r) {
		solutions.add(r);
	}
	
	/**
	 * 
	 * @param r este rezolvarea care trebuie stearsa
	 */
	public void deleteSolution(AssignmentSolution r) {
		solutions.remove(r);
	}
	
	public List<AssignmentSolution> getSolutions(){
		return solutions;
	}

	/**
	 * @param deadline va fi data limita la care se poate preda tema
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return data limita la care se poate preda tema
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param name va fi denumirea temei
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return denumirea temei
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param course va fi cursul de care apartine tema curenta
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return cursul de care apartine tema
	 */
	public Course getCourse() {
		return course;
	}

        /**
         * 
         * @return textul anuntului
         */
        public String getText() {
            return text;
        }

        /**
         * 
         * @param text va fi textul anuntului
         */
        public void setText(String text) {
            this.text = text;
        }


	
	/**
	 * @return un string cu denumirea cursului, titlul temei si 
	 */
	 @Override
	public String toString() {
		return course.getName()+" "+name+" "+deadline;
	}
}

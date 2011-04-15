package business.model;

import java.util.ArrayList;

public class Specialty {
	private ArrayList<Course> courses;
	private String name;
	private int numberOfYears;
	/**
	 * @param courses este o lista care contine cursurile care se predau
	 *        in cadrul acestei specializari
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	/**
	 * @return lista care contine cursurile care se predau in cadrul
	 * 			acestei specializari
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	/**
	 * @param name este numele specializarii
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return numele specializarii
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param numberOfYears este numarul de ani asociat specializarii 
	 */
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	/**
	 * @return numarul de ani asociat specializarii
	 */
	public int getNumberOfYears() {
		return numberOfYears;
	}
}

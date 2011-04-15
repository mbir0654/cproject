package business.model;

import java.util.ArrayList;

public class Faculty {
	private String university = "";
	private String name = "";
	private String address = "";
	private ArrayList<Specialty> specialties = new ArrayList<Specialty>();
	
	/**
	 * Constructorul implicit
	 */
	public Faculty() {
	}
	
	/**
	 * verifica daca 2 facultati sunt identice
	 * 
	 * @param f este facultatea cu care comparam
	 * 
	 * @return true daca facultatea curenta este identica
	 * 	 	   cu dea data ca parametru
	 */
	public boolean equals(Faculty f){
		if(this.university == f.getUniversity() &&
		   this.name == f.getName() &&
		   this.address == f.getAddress())
			return true;
		return false;
	}

	/**
	 * @param university va fi Univestiatea de care apartine facultatea
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return Univestiatea de care apartine facultatea
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param name va fi numele facultatii
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return numele facultatii
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param address va fi adresa facultatii
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return adresa facultatii
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param specialties ca fi lista cu specialitatile facultatii
	 */
	public void setSpecialties(ArrayList<Specialty> specialties) {
		this.specialties = specialties;
	}

	/**
	 * @return lista cu specialitatile facultatii
	 */
	public ArrayList<Specialty> getSpecialties() {
		return specialties;
	}
}

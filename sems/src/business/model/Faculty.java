package business.model;

import java.util.ArrayList;

public class Faculty {
	private String university = "";
	private String name = "";
	private String address = "";
	private ArrayList<Specialty> specialties = new ArrayList<Specialty>();
	
	public Faculty() {
	}

	/**
	 * @param university este Univestiatea de care apartine facultatea
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
	 * @param name este numele facultatii
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
	 * @param address  este adresa facultatii
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
	 * @param specialties este lista cu specialitatile facultatii
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

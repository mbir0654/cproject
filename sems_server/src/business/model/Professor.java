package business.model;

import java.util.ArrayList;
import java.util.List;


public class Professor extends User{
	private List<Group> groups;
        private List<Course> courses;
        private List<Announcement> announcements;
        private int id;
	/**
	 * Constructorul implicit
	 * 
	 * @see User#User()
	 */
	public Professor(){
        groups = new ArrayList<Group>();
        courses = new ArrayList<Course>();
        announcements = new ArrayList<Announcement>();
	}
	
	/**
	 * Constructorul de copiere
	 * 
	 * @param p este Profesorul care se va duplica
	 * 
	 * @see User#User(User)
	 */
	public Professor(Professor p){
		super(p);
		groups=p.getGroups();
        courses=p.getCourses();
        announcements=p.getAnnouncements();
        id = p.id;
	}
	
	/**
	 * verifica daca 2 profesori sunt identici
	 * 
	 * @param p este profesorul cu care comparam
	 * 
	 * @return true daca profesorul curent este identic
	 *         cu cel dat ca parametru
	 *         
	 * @see User#equals(User)
	 */
	public boolean equals(Professor p){
		if(super.equals(p))
			return true;
		return false;
	}

	/**
	 * @param groups the groups to set
	 */
	public void addGroup(Group groups) {
		this.groups.add(groups);
	}

	/**
	 * @return the groups
	 */
	public ArrayList<Group> getGroups() {
		return (ArrayList<Group>) groups;
	}

    /**
     * 
     * @return lista de cursuri predate de acest profesor
     */
	public List<Course> getCourses() {
        return courses;
    }

    /**
     * 
     * @return lista de anunturi facute de acest profesor
     */
	public List<Announcement> getAnnouncements() {
        return this.announcements;
    }
	
	/**
	 * 
	 * @param a este anuntul pe care il adauga profesorul
	 */
    public void addAnnouncement(Announcement a) {
        this.announcements.add(a);
    }
    
    /**
     * 
     * @return id studentului in baza de date
     */
    public int getId() {
		return id;
	}
    
    /**
     * 
     * @param id este noul identificator
     */
    public void setId(int id) {
		this.id = id;
	}
} 


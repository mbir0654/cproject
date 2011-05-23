package business.model;

import java.util.ArrayList;
import java.util.List;


public class Professor extends User{
	private List<Group> groups;
        private List<Course> courses;
        private List<Announcement> announcements;
	/**
	 * Constructorul implicit
	 * 
	 * @see User#User()
	 */
	public Professor(){
            groups = new ArrayList<Group>();
            courses = new ArrayList<Course>();
            announcements = new ArrayList<Announcement>();
		//atributele ne-continute in User ar trebui inititalizate aici
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
		// TODO restul atributelor se copiaza
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

        public List<Course> getCourses() {
                return courses;
        }

    public List<Announcement> getAnnouncements() {
        return this.announcements;
    }
    public void addAnnouncement(Announcement a) {
        this.announcements.add(a);
    }
    
} 


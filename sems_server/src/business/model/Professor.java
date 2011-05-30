package business.model;

import java.util.ArrayList;
import java.util.List;

import data.dbutil.DbObject;


public class Professor extends User{
    private List<Group> groups;
    private List<Course> courses;
    private List<Announcement> announcements;
    private String title;

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
        title = p.title;
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
    public void addGroup(Group group) {
            groups.add(group);
    }

    /**
     * @return the groups
     */
    public ArrayList<Group> getGroups() {
            return (ArrayList<Group>) groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    /**
     * 
     * @return lista de cursuri predate de acest profesor
     */
	public List<Course> getCourses() {
        return courses;
    }
        public void addCourse(Course course){
            courses.add(course);
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
    
    
    public String getTitle() {
		return title;
	}
    
    
    public void setTitle(String title) {
		this.title = title;
	}

    @Override
    public String toString() {
        return title+". "+super.toString();
    }
    
    @Override
    public List<DbObject> toDbObjectList() {
    	DbObject db1 = new DbObject("userName",userName);
    	DbObject db2 = new DbObject("teacherTitle",title);
    	List<DbObject> l = new ArrayList<DbObject>();
    	l.add(db1); l.add(db2);
    	return l;
    }
    
    
} 


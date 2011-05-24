package business.model;

import java.util.Date;

public class Announcement {
	private String announcement = "";
    private String subject = "";
	private Professor prof;
	private Course course;
    private Date date;
	
	
	/**
	 * Constructor parametrizat
	 * 
	 * @param a este textul anuntului
	 * 
	 * @param p este profesorul care a facut anuntul
	 */
	public Announcement(String msg, String subj, Professor p) {
		setAnnouncement(msg);
                this.subject=subj;
                setProf(p);
                this.date= new Date();
	}
	
	public Announcement() {
		this.date = new Date();
	}
	
	/**
	 * Verifica daca 2 anunturi sunt identice
	 * 
	 * @param a este anuntul cu care comparam
	 * 
	 * @return true daca anuntul curent este identic cu cel
	 * 		   dat ca parametru
	 */
	public boolean equals(Announcement a){
		if(announcement == a.getAnnouncement())
			return true;
		return false;
	}

	/**
	 * @param announcement va fi textul anuntului
	 */
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	/**
	 * @return the textul anuntului
	 */
	public String getAnnouncement() {
		return announcement;
	}

	/**
	 * @param prof va fi profesorul care a facut anuntul
	 */
	public void setProf(Professor prof) {
		this.prof = prof;
	}

	/**
	 * @return numele profesorului care a facut anuntul
	 */
	public String getProf() {
		return prof.getFirstName()+" "+prof.getLastName();
	}

	/**
	 * @param course va fi cursul pentru care se face acnuntul
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return cursul pentru care se face acnuntul curent
	 */
	public Course getCourse() {
		return course;
	}

    public Date getData() {
        return date;
    }

    public String getSubiect() {
        return subject;
    }
    @Override
    public String toString() {
        return this.subject;
    }

    public void setData(Date d) {
        this.date=d;
    }
}

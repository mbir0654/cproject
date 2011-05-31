package business.model;

import java.io.Serializable;
import java.util.Date;

public class Announcement implements Serializable {
	private String announcement = "";
    private String subject = "";
	private Professor prof;
	private Course course;
    private Date date;


	/**
	 * Constructor parametrizat
	 *
	 * @param msg este textul anuntului
	 *
	 * @param subj este titlul anuntului
	 *
	 * @param d este data anuntului
	 *
	 * @param c este cursul pentru care s-a facut anuntul
	 */
	public Announcement(String msg, String subj, Date d, Course c) {
		this.announcement = msg;
        this.subject=subj;
        this.date = d;
        this.course = c;
	}

	/**
	 * constructor implicit;
	 */
	public Announcement() {
		this.date = new Date();
	}

	public Announcement(Announcement a){
		this.announcement = a.announcement;
        this.subject = a.subject;
        this.date = a.date;
        this.course = a.course;
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

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getSubject() {
		return subject;
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
	 * @return profesorul care a facut anuntul
	 */
	public Professor getProf() {
		return prof;
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

    /**
     * @return data la care a fost facut anuntul
     */
	public Date getData() {
        return date;
    }

    /**
	 *
	 * @param d este noua data a anuntului
	 */
    public void setData(Date d) {
        this.date=d;
    }

    /**
     * setez subiectul anuntului
     * @param subject
     */
    public void  setSubject(String subject){
        this.subject = subject;
    }

    /**
     * @return un string cu titlul anuntului si data la care a fost facut
     */
    @Override
    public String toString() {
        return subject+" - "+date;
    }
}

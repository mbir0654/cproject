package business.model;

public class Announcement {
	private String announcement = "";
	
	public Announcement(String a) {
		setAnnouncement(a);
	}
	
	public Announcement() {
	}
	
	/**
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
}

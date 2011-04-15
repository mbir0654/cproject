package business.model;

public class Announcement {
	private String announcement = "";
	
	public Announcement(String a) {
		setAnnouncement(a);
	}
	
	public Announcement() {
	}

	/**
	 * @param anunt este textul anuntului
	 */
	public void setAnnouncement(String anunt) {
		this.announcement = anunt;
	}

	/**
	 * @return the textul anuntului
	 */
	public String getAnnouncement() {
		return announcement;
	}
}

package business.model;

public class Announcement {
	private String announcement;
	
	public Announcement(String a){
		announcement = a;
	}
	public Announcement(){
		announcement = "";
	}
	public void setAnunt(String a){
		announcement = a;
	}
	public String getAnunt(){
		return announcement;
	}
}

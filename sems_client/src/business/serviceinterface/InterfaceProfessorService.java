package business.serviceinterface;

import business.model.*;

import java.util.List;

/**
 * @author biskis
 *
 */

public interface InterfaceProfessorService {
    public String hello();
    public List<Course> getCourses(Professor professor);

    public List<Group> getGroups(Professor professor);

    public List<Announcement> getAnnouncements(Professor professor);

    public List<Student> getStudentsFromGroup(Group group);

    public void addAnnouncement(Professor professor,Announcement announcement);

    public void deleteAnnouncemnt(Announcement announcement);
    public List<Student> getStudentsByCourse(Course course);


	public void exitSystem();
	public void mannageAnnouncements();
	public void viewCourses();
	public void mannageStudentsGroups();
	public void generateCatalog();
	public void manageHomeworks() ;
	public void manageTests() ;
	public void manageExams() ;

}

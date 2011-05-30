package business.serviceinterface;

import business.model.*;

import java.util.List;

/**
 * @author biskis
 *
 */
public interface InterfaceStudentService {
    public List<Announcement> getAnnouncements(Student student);
    public String hello();
    public boolean setContract(Student student, Contract contract);

    public List<Course> getAvailableCourses(Student student);

    public List<Grade> getGrades(Course course);
	public void sendHomeWork();


}

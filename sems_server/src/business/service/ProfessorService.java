package business.service;

import business.model.*;
import business.serviceinterface.InterfaceProfessorService;
import data.repositorydb.AnnouncementRepository;
import data.repositorydb.FacultyRepository;
import data.repositorydb.ProfessorRepository;
import data.repositorydb.StudentRepository;
import data.repositoryinterface.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bsk
 *
 */
final class ProfessorService implements InterfaceProfessorService {

//    private Repository<Announcement> announcementRepository = AnnouncementRepository.getInstance();
    private Repository<Student> studentRepository = StudentRepository.getInstance();

    public String hello() {
        return "hello, from prof";
    }

    @SuppressWarnings("unused")
	private ProfessorRepository professors = ProfessorRepository.getInstance();

    public List<Course> getCourses(Professor professor){
        System.out.println("Get cursuri pt profesor: " + professor + ": " + professor.getCourses());
        return  professor.getCourses();
    }

    public List<Group> getGroups(Professor professor){
        System.out.println("Get grupe pt profesor: " + professor + ": " + professor.getGroups());
        return  professor.getGroups();
    }

    public  List<Announcement> getAnnouncements(Professor professor){
        System.out.println("Get anunturi pt profesor: " + professor + ": " + professor.getAnnouncements());
        return professor.getAnnouncements();
    }

    public  List<Student> getStudentsFromGroup(Group group){
        System.out.println("Get studenti din grupa: " + group + ": " + group.getStudents());
        return  group.getStudents();
    }

    public void addAnnouncement(Professor professor,Announcement announcement){
        System.out.println("Adaugam anunt: " + announcement + " pentru profesor: " + professor);
        professor.addAnnouncement(announcement);
        System.out.println("Anunturi curente:" + professor.getAnnouncements().toString());
    }

    public void deleteAnnouncemnt(Announcement announcement){
        //announcementRepository.delete(announcement);
    }

    public List<Student> getStudentsByCourse(Course course){
        List<Student> students = new ArrayList<Student>();
        for(Student student:students){
            if(student.getContract().getCourses().contains(course))
                students.add(student);
        }
        return students;
    }

    public void exitSystem() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mannageAnnouncements() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void viewCourses() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mannageStudentsGroups() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void generateCatalog() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void manageHomeworks() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void manageTests() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void manageExams() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}

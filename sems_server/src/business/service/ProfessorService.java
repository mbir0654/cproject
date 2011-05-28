package business.service;

import business.model.*;
import business.serviceinterface.InterfaceProfessorService;
import data.repositorydb.ProfessorRepository;

import java.util.List;

/**
 * @author bsk
 *
 */
final class ProfessorService implements InterfaceProfessorService {

    public String hello() {
        return "hello, from prof";
    }

    private ProfessorRepository professors = ProfessorRepository.getInstance();

    public List<Course> getCourses(Professor professor){
        return  professor.getCourses();
    }

    public List<Group> getGroups(Professor professor){
        return  professor.getGroups();
    }

    public  List<Announcement> getAnnouncements(Professor professor){
        return professor.getAnnouncements();
    }

    public  List<Student> getStudentsFromGroup(Group group){
        return  group.getStudents();
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

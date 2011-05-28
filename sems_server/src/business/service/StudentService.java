/**
 * 
 */
package business.service;

import business.model.*;
import business.serviceinterface.InterfaceStudentService;
import data.repositorydb.CourseRepository;
import data.repositorydb.StudentRepository;
import sun.rmi.runtime.NewThreadAction;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bsk
 *
 */
final class StudentService implements InterfaceStudentService{


    public String hello() {
        return "greetings, from student";
    }

    /**
	 * The student for which we offer the services.
	 */
	
	private StudentRepository studentRepository = StudentRepository.getInstance();

    public List<Course> getCourses(Student student){
        return student.getContract().getCourses();
    }

    public List<Announcement> getAnnouncements(Student student){
        List<Announcement> announcements = new ArrayList<Announcement>();
        for(Course coutse:student.getContract().getCourses())
            for(Announcement announcement:coutse.getAnnouncements())
                announcements.add(announcement);
        return  announcements;
    }

    public boolean setContract(Student student, Contract contract){
        student.setContract(contract);
        return  true;
    }

    public List<Course> getAvailableCourses(Student student){
        List<Course> currentCourses = student.getContract().getCourses();
        List<Course> availableCourses = new ArrayList<Course>();
        availableCourses = student.getSpecialty().getCourses();
        for(Course course:availableCourses)
            if(currentCourses.contains(course))
                availableCourses.remove(course);
        return  availableCourses;
    }

    public List<Grade> getGrades(Course course){
        List<Grade> grades = new ArrayList<Grade>();
        for(Exam exam:course.getExams()){
            for(Grade grade:exam.getGrades()){
                grades.add(grade);
            }
        }
        return grades;
    }
    
    public void viewCourses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void viewAnnouncements() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void makeContract() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void viewAvailableCourses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void viewMatterials() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void viewGrades() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sendHomeWork() {
        throw new UnsupportedOperationException("Not supported yet.");

        //To change body of implemented methods use File | Settings | File Templates.

    }

}

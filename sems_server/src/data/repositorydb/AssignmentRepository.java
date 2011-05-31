package data.repositorydb;

import business.model.Assignment;
import business.model.Course;
import data.repositoryinterface.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CLJ
 * Date: 5/28/11
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssignmentRepository implements Repository<Assignment>{
    private List<Assignment> l = new ArrayList<Assignment>();
    private CourseRepository courses = CourseRepository.getInstance();

    private static final AssignmentRepository assigments = new AssignmentRepository();

    public static AssignmentRepository getInstance(){
        return  assigments;
    }
    private AssignmentRepository(){
        for(Course course:courses.getAll())
            l.addAll(course.getAssignments());
    }

    public void add(Assignment item) {
        l.add(item);
        courses.update(courses.findByName(item.getCourse().getCod()));
    }

    public List<Assignment> getAll() {
        return l;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Assignment findByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void update(Assignment item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Assignment item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}


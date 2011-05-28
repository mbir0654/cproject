package data.repositorydb;

import business.model.Assignment;
import business.model.Course;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CLJ
 * Date: 5/28/11
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssignmentRepository {
    private List<Assignment> l;
    private CourseRepository courses = CourseRepository.getInstance();

    private static final AssignmentRepository assigments = new AssignmentRepository();

    public static AssignmentRepository getInstance(){
        return  assigments;
    }
    private AssignmentRepository(){
        for(Course course:courses.getAll())
            for(Assignment assignment:course.getAssignments())
                l.add((assignment));
    }
}


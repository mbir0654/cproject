package server;

import business.model.*;
import data.repositorydb.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        Student s = StudentRepository.getInstance().findByName("ovi");
        List<Course> lc = new ArrayList<Course>(s.getContract().getCourses());
        for(Course c : CourseRepository.getInstance().getAll()){
            //for(Course cc : lc)
                if(c.getSpecializare().equals(s.getSpecialty())){
                     s.getContract().addCourse(c);
            }
        }
        System.out.println(s.getContract());
        StudentRepository.getInstance().update(s);
    }
}

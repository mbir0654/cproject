package server;

import business.model.*;
import business.model.AssignmentSolution;
import data.repositorydb.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) throws SQLException {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        StudentRepository pr = StudentRepository.getInstance();
        List<Group> l = GroupRepository.getInstance().getAll();
        Student a = pr.findByName("oti");
        System.out.println(a.getContract());
        for(Course c : SpecialityRepository.getInstance().findByName(a.getSpecialty().getName()).getCourses()){
            for (Assignment as : c.getAssignments()){
                AssignmentSolution assSol = new AssignmentSolution(a, as, Calendar.getInstance().getTime(), "filename nou " + as.getName());
                System.out.println();
            }
        }
        //System.out.println(a.getSolutions());
        StudentRepository.getInstance().update(a);
        /*a.setFirstName("Otniel");
        a.setLastName("Nicola");
        a.setUserName("oti");
        a.setPassword("1a1dc91c907325c69271ddf0c944bc72");
        a.setCnp("1234567890");
        a.setNrMat("10688");
        a.setContract(new Contract(a));
        System.out.println(a.getContract());
        a.setYear(1);
        a.setGroup(l.get(0));
        l.get(0).addStudent(a);
        a.setSpecialty(l.get(0).getSpecialty());
        pr.add(a);*/
        //pr.delete(a);
        //ResultSet rs = new DbUtil().getDate("select* from users");
        //while(rs.next())
            //System.out.println(rs.getString(1));
        //for(Professor p : ProfessorRepository.getInstance().getAll())
            //System.out.println(p.getCourses());
    }
}

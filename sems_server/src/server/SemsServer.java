package server;

import business.model.*;
import business.service.AppService;
import data.dbutil.DbUtil;
import data.repositorydb.*;
import data.repositoryinterface.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        Student a = new Student();
        a.setFirstName("Otniel");
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
        System.out.println(a);
        pr.add(a);
        //pr.delete(a);
        //ResultSet rs = new DbUtil().getDate("select* from users");
        //while(rs.next())
            //System.out.println(rs.getString(1));
        //for(Professor p : ProfessorRepository.getInstance().getAll())
            //System.out.println(p.getCourses());
    }
}

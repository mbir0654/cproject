package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import business.model.*;
import business.service.AppService;
import data.repositorydb.*;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
        @SuppressWarnings("unused")
		ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        //FacultyRepository fr = FacultyRepository.getInstance();
        AppService aps = AppService.getInstance();
        aps.ValidateUser("adi", "1a1dc91c907325c69271ddf0c944bc72");
        /*for(Faculty f: fr.getAll()){
        System.out.println(f.getSpecialties());
        for (Specialty s : f.getSpecialties()){
        System.out.println(s.getGroups());
        for(Group g : s.getGroups()){
        System.out.println(g);
        for(Student st : g.getStudents()){
        System.out.println(st);
        }
        }
        }
        }*/
    }
}

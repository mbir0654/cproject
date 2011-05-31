package server;

import business.model.*;
import data.repositorydb.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        Faculty f= FacultyRepository.getInstance().findByName("Litere");
        System.out.println(f);
        Specialty s = new Specialty();
        s.setFaculty(f);
        f.addSpecialty(s);
        s.setName("Limbi moderne aplicate ");
        s.setNumberOfYears(3);
        SpecialityRepository.getInstance().add(s);
    }
}

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
        /*Professor p = new Professor();
        p.setPassword("1a1dc91c907325c69271ddf0c944bc72");
        p.setFirstName("Otniel");
        p.setLastName("Nicola");
        p.setUserName("oti");
        p.setTitle("asistent");
        p.addCourse(CourseRepository.getInstance().findByName("BMC-INFO"));
        for(Announcement ann  : AnnouncementRepository.getInstance().getAll())
        p.addAnnouncement(new Announcement(ann.getAnnouncement(),ann.getSubject(),ann.getData(),CourseRepository.getInstance().findByName("BMC-INFO")));
        System.out.println(p.getAnnouncements());
        p.setTitle("Prof. Doctor ");
        p.addGroup(GroupRepository.getInstance().findByName("221"));
        ProfessorRepository.getInstance().update(p);*/
    }
}

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
       Faculty f = new Faculty();
       f.setAddress("Str. Mihail Kogalniceanu Nr. 1");
       f.setName("Litere");
       FacultyRepository.getInstance().add(f);
    }
}

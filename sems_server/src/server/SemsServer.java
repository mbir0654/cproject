package server;

import business.model.*;
import business.service.AdministratorService;
import business.serviceinterface.InterfaceAdministratorService;
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
    }
}

package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import business.model.*;
import data.repositorydb.*;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
        @SuppressWarnings("unused")
		ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
    }
}

package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import business.model.*;
import data.repositorydb.*;

/**
 * Created by IntelliJ IDEA.
 * User: myh
 * Date: 5/23/11
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class SemsServer {
    public static void main(String args[]) {
        @SuppressWarnings("unused")
		ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        /*AdministratorRepository ar = AdministratorRepository.getInstance();
        for( Administrator a : ar.getAll()){
        	System.out.println(a.toString());
        }*/
    }
}

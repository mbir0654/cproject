package server;

import business.service.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        AppService.getInstance().ValidateUser("bobby", "1a1dc91c907325c69271ddf0c944bc72");
    }
}

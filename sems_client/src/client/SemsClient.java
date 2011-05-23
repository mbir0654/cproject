package client;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.InterfaceAppService;

/**
 * Created by IntelliJ IDEA.
 * User: myh
 * Date: 5/23/11
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SemsClient {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:client/clientContext.xml");
        SemsClient app = (SemsClient) factory.getBean("semsClient");
        app.run();
    }

    public void run() {

    }

    private InterfaceAppService appService;

    public void setAppService(InterfaceAppService service) {
        this.appService = service;
    }

}

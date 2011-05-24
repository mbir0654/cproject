package client;

import business.serviceinterface.InterfaceAppService;

import business.serviceinterface.*;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println(appService.hello());
        System.out.println(studentService.hello());
        System.out.println(adminService.hello());
        System.out.println(profService.hello());
    }

    public void setAppService(InterfaceAppService service) {
        this.appService = service;
    }

    public void setAdminService(InterfaceAdministratorService service) {
        this.adminService = service;
    }

    public void setProfService(InterfaceProfessorService service) {
        this.profService = service;
    }

    public void setStudentService(InterfaceStudentService service) {
        this.studentService = service;
    }

    private InterfaceAppService appService;
    private InterfaceAdministratorService adminService;
    private InterfaceProfessorService profService;
    private InterfaceStudentService studentService;
}

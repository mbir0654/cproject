package client;

import business.serviceinterface.InterfaceAppService;

import business.serviceinterface.*;
import controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.frameLogin;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: myh
 * Date: 5/23/11
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class RMIUtil {
    public static void init() {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:client/clientContext.xml");
        RMIUtil app = (RMIUtil) factory.getBean("semsClient");
        app.test();
    }

    public void test() {
        System.out.println(appService.hello());
        System.out.println(studentService.hello());
        System.out.println(adminService.hello());
        System.out.println(profService.hello());
    }

    public static InterfaceAppService getAppService(){
        return appService;
    }

    public static InterfaceAdministratorService getAdminService() {
        return adminService;
    }

    public static InterfaceProfessorService getProfService() {
        return profService;
    }

    public static InterfaceStudentService getStudentService() {
        return studentService;
    }

    public void setAppService(InterfaceAppService service) {
        appService = service;
    }

    public void setAdminService(InterfaceAdministratorService service) {
        adminService = service;
    }

    public void setProfService(InterfaceProfessorService service) {
        profService = service;
    }

    public void setStudentService(InterfaceStudentService service) {
        studentService = service;
    }

    private static InterfaceAppService appService;
    private static InterfaceAdministratorService adminService;
    private static InterfaceProfessorService profService;
    private static InterfaceStudentService studentService;
}

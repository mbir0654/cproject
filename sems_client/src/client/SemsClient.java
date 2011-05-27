package client;

import controller.Controller;

/**
 * Created by IntelliJ IDEA.
 * User: myh
 * Date: 5/26/11
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SemsClient {
    public static void main(String[] args) {
        RMIUtil.init();
        Controller loginController = new Controller(RMIUtil.getAppService());
        loginController.openLoginFrame();
    }
}

package client;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.UIManager;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: myh
 * Date: 5/26/11
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SemsClient {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                        //getCrossPlatformLookAndFeelClassName()
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        RMIUtil.init();
        Controller loginController = new Controller(RMIUtil.getAppService());
        loginController.openLoginFrame();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Administrator;
import javax.swing.DefaultListModel;

import business.serviceinterface.InterfaceAdministratorService;
import ui.*;
/**
 *
 * @author snoopy
 */
public class ControllerAdmin {
    private final Administrator a;
    private final InterfaceAdministratorService administratorService;
    public ControllerAdmin(Administrator adm, InterfaceAdministratorService service) {
        this.a=adm;
        administratorService = service;
    }

}

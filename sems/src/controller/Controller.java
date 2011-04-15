/**
 * 
 */
package controller;

import business.service.AppService;

/**
 * Aceasta clasa se va ocupa exclusiv de contolul ferestrelor si va face parte
 * din client in versiunea finala a aplicatiei
 * @author otniel
 *
 */
public class Controller {
	
	@SuppressWarnings("unused")
	private AppService apps;
	
	public Controller(){
		apps = AppService.getInstance();
	}
	
}

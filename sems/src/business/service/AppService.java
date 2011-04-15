/**
 * 
 */
package business.service;


/**
 * @author myh
 *
 */
public class AppService {
	
	private AdministratorService as;
	private ProfessorService ps;
	private StudentService ss;
	/**
	 * atribut privat pentru singleton
	 */
	private static AppService apps = new AppService();
	
	/**
	 *  cvonstuctor privat pentru singleton
	 */
	private AppService(){
		
	}
	
	/**
	 * 
	 * @return atributul privat <b>apps</b>, pentru a asigura unicitatea 
	 * 		   serviciului in toata aplicatia 
	 */
	public static AppService singletonAppS(){
		return apps;
	}

}

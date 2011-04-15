/**
 * 
 */
package business.service;


/**
 * @author myh
 *
 */
public class AppService {
	
	@SuppressWarnings("unused")
	private AdministratorService as;
	@SuppressWarnings("unused")
	private ProfessorService ps;
	@SuppressWarnings("unused")
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
	public static AppService getInstance(){
		return apps;
	}

}

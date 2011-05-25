package business.model;

/**
 * 
 * @author otniel
 *
 */
public class CourseMaterial {
	private String path;
	byte[] fisier;
	
	public CourseMaterial() {
		path = "";
	}
	
	/**
	 * 
	 * @param path va fi noua cale a fisierului
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * 
	 * @return calea fisierului
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * @return un string cu numele fisierului
	 */
	@Override
	public String toString() {
		return path;
	}
}

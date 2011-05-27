package business.model;

import java.io.Serializable;

/**
 * 
 * @author otniel
 *
 */
public class CourseMaterial implements Serializable {
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

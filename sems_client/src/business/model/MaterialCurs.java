package business.model;

/**
 * 
 * @author otniel
 *
 */
public class MaterialCurs {
	private String path;
	byte[] fisier;
	
	public MaterialCurs() {
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
}

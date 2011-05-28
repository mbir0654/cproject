/**
 * 
 */
package data.repositoryinterface;

import java.util.List;

/**
 * @author Bogdan Bot-Rus
 *
 */

public interface Repository<T>{
	
	/**
	 * adauga in colectie elementul indicat
	 * 
	 * @param item este elementul care se adauga in colectie
	 */
	public void add(T item);
	
	/**
	 * 
	 * @return o lista cu elementele din colectie
	 */
	public List<T> getAll();
	
	/**
	 * cauta in colectie un obiect dupa nume
	 * 
	 * @param id este numele dupa care se cauta elementul
	 * 
	 * @return elementul cu numele <b>id</b>
	 */
	public T findByName(String name);

	/**
	 * mai vedem noi ce face asta :D
	 */
	public void update(T item);
	
	/**
	 * sterge din colectie obiectul indicat
	 * 
	 * @param item este obiectul ce trebuie sters din colectie
	 */
	public void delete(T item);
}

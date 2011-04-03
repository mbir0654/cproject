/**
 * 
 */
package data.repositoryinterface;

import java.util.List;

/**
 * @author Bogdan Bot-Rus
 *
 */

public interface Repository<T> {
	// C Append.
	public void add(T item);
	// R Read.
	public List<T> getAll();
	public T find(String id);
	// U Update
	public void update(T item);
	// D Delete.
	public void delete(T item);
}

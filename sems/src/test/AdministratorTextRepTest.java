/**
 * 
 */
package test;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import business.model.Administrator;
import data.repositorytext.AdministratorTextRep;

/**
 * @author Bogdan Bot-Rus
 *
 */
public class AdministratorTextRepTest {
	
	@Test
	public void getAllSizeTest() {
		AdministratorTextRep repository = new AdministratorTextRep();
		List<Administrator> items = repository.getAll();
		int initialSize = items.size();
		Administrator item = new Administrator();
		item.setFirstName("Gica");
		item.setLastName("Petrescu");
		item.setUserName("peip2134");
		item.setPassword("admin");
		
		repository.add(item);
		Assert.assertEquals(repository.getAll().size(), initialSize + 1);
		repository.delete(item);
		Assert.assertEquals(repository.getAll().size(), initialSize);
	}
	
}

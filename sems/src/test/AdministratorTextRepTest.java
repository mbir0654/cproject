/**
 * 
 */
package test;

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
		Administrator item = new Administrator();
		repository.add(item);
		Assert.assertEquals(repository.getAll().size(), 1);
		repository.delete(item);
		Assert.assertEquals(repository.getAll().size(), 0);
	}
	
}

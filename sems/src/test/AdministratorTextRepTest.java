/**
 * 
 */
package test;

import data.repositorytext.AdministratorTextRep;
import junit.framework.Assert;
import business.model.Administrator;


/**
 * @author Bogdan Bot-Rus
 *
 */
public class AdministratorTextRepTest {
	public void getAllSizeTest(){
		AdministratorTextRep repository = new AdministratorTextRep();
		Administrator item = new Administrator();
		repository.add(item);
		Assert.assertEquals(repository.getAll().size(), 1);
		repository.delete(item);
		Assert.assertEquals(repository.getAll().size(), 0);
	}

}

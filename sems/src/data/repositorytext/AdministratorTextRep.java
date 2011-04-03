/**
 * 
 */
package data.repositorytext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import business.model.Administrator;
import data.repositoryinterface.Repository;

/**
 * @author Bogdan Bot-Rus
 *
 */
public class AdministratorTextRep implements Repository<Administrator> {
	private static final String IDS_AdministratorsTxt = "data/administrator.txt";
	List<Administrator> items = new ArrayList<Administrator>();
	
	public AdministratorTextRep()
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(IDS_AdministratorsTxt)));
			String firstName;

			while ((firstName = br.readLine()) != null) 
			{
				String lastName = br.readLine();
				String userName = br.readLine();
				String password = br.readLine();
				Administrator item = new Administrator();
				item.
				//firstName, lastName, userName, price
				items.add(s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// throw new RepositoryException("Administrators file does not exist..");
		} catch (IOException e) {
			// throw new RepositoryException("Corrupted administrators file...");
		}
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Administrator item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Administrator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Administrator item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Administrator item) {
		// TODO Auto-generated method stub
		
	}

}

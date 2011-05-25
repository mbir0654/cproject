/**
 * 
 */
package data.repositorytext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import business.model.Administrator;
import data.repositoryinterface.Repository;

/**
 * @author Bogdan Bot-Rus
 *
 */
public class AdministratorTextRep implements Repository<Administrator> {
	private static final String IDS_AdministratorsTxt = "src/test/Administrators.txt";
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
				item.setFirstName(firstName);
				item.setLastName(lastName);
				item.setUserName(userName);
				item.setPassword(password);
				items.add(item);
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
		items.add(item);
		save();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Administrator> getAll() {
		return items;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 *
	@Override
	public void update(Administrator item) {
		Administrator administrator = find(item.getUserName());
		if (administrator != null)
		{
			administrator.setFirstName(item.getFirstName());
			administrator.setLastName(item.getLastName());
			administrator.setPassword(item.getPassword());
		}
		save();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Administrator item) {
		Administrator administrator = findByName(item.getUserName());
		if (administrator != null)
		{
			items.remove(administrator);
			save();
		}
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Administrator findByName(String id) {
		Administrator result = null;
		List<Administrator> administrators = getAll();
		for (Administrator administrator : administrators) {
			if (administrator.getUserName().equals(id)) {
				result = administrator;
			}
		}
		return result;
	}
	
	// Saves all of the items to the storage.
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(IDS_AdministratorsTxt)));
			List<Administrator> administrators = getAll();
			for (Administrator administrator : administrators) 
			{
				bw.write(administrator.getFirstName() + "\n");
				bw.write(administrator.getLastName() + "\n");
				bw.write(administrator.getUserName() + "\n");
				bw.write(administrator.getPassword() + "\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
			// throw new RepositoryException("Students file does not exist..");
		} catch (IOException e) {
			// throw new RepositoryException("Corrupted students file...");
		}
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update()
	 */
	@Override
	public void update(Administrator item) {
		// TODO Auto-generated method stub
		
	}

}

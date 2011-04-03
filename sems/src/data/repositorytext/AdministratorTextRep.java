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
	 */
	@Override
	public void update(Administrator item) {
		List<Administrator> materials = getAll();
		for (Administrator material : materials) {
			if (material.getUserName().equals(item.getUserName())) 
			{
				material.setFirstName(item.getFirstName());
				material.setLastName(item.getLastName());
				material.setPassword(item.getPassword());
			}
		}
		save();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Administrator item) {
		Administrator materialToDelete = find(item.getUserName());
		if (item != null)
		{
			materials.remove(materialToDelete);
			save();
		}
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Administrator find(String id) {
		Administrator result = null;
		List<Administrator> materials = getAll();
		for (Administrator material : materials) {
			if (material.getName().equals(name)) {
				result = material;
			}
		}
		return result;
	}
	
	// Saves all of the items to the storage.
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(IDS_AdministratorsTxt)));
			List<Administrator> materials = getAll();
			for (Administrator material : materials) 
			{
				bw.write(material.getCode() + "\n");
				bw.write(material.getName() + "\n");
				bw.write(String.valueOf(material.getQuantity()).toString() + "\n");
				bw.write(String.valueOf(material.getPrice()).toString() + "\n");
			}
			;
			bw.close();
		} catch (FileNotFoundException e) {
			// throw new RepositoryException("Students file does not exist..");
		} catch (IOException e) {
			// throw new RepositoryException("Corrupted students file...");
		}
	}

}

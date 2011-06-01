/**
 * 
 */
package data.repositorydb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.Faculty;
import business.model.Specialty;
import data.dbutil.DbUtil;
import data.dbutil.SqlFunctions;

import data.repositoryinterface.Repository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author otniel
 *
 */
public class SpecialityRepository implements Repository<Specialty>{
	
    private List<Specialty> l;
    private FacultyRepository facultys = FacultyRepository.getInstance();

    private static final SpecialityRepository specialitys = new SpecialityRepository();

    public static SpecialityRepository getInstance(){
        return  specialitys;
    }

    
    private SpecialityRepository(){
        l = new ArrayList<Specialty>();
        for(Faculty faculty:facultys.getAll())
                l.addAll(faculty.getSpecialties());
    }

    /**
     * @see data.repositoryinterface.Repository#add(java.lang.Object)
     */
    @Override
    public void add(Specialty item) {
    try {
        DbUtil dbu = new DbUtil();
        if(SqlFunctions.insert("specializations", item.toDboBjectList(), dbu))
            if(SqlFunctions.insert("faculties_specializations", item.toDboBjectListSF(), dbu))
                l.add(item);
        dbu.close();
    } catch (SQLException ex) {
        Logger.getLogger(SpecialityRepository.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * @see data.repositoryinterface.Repository#getAll()
     */
    @Override
    public List<Specialty> getAll() {
            List<Specialty> r = new ArrayList<Specialty>();
            r.addAll(l);
            return r;
    }

    /**
     * @see data.repositoryinterface.Repository#findNyName(java.lang.String)
     */
    @Override
    public Specialty findByName(String id) {
            for(Specialty s : l){
                    if(s.getName().equalsIgnoreCase(id))
                            return s;
            }
            return null;
    }

    /**
     * @see data.repositoryinterface.Repository#update(java.lang.Object)
     */
    @Override
    public void update(Specialty item) {
        try {
            SqlFunctions.update("specializations",item.toDboBjectList(), "spName='"+item.getName()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(SpecialityRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @see data.repositoryinterface.Repository#delete(java.lang.Object)
     */
    @Override
    public void delete(Specialty item) {
        try {
            if(SqlFunctions.delete("specializations", "spName = '" + 
                    item.getName() + "' and numberOfYears = '" +
                    item.getNumberOfYears()))
                l.remove(item);
        } catch (SQLException ex) {
            Logger.getLogger(SpecialityRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
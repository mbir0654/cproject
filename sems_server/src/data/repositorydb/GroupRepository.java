/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data.repositorydb;

import business.model.Group;
import business.model.Professor;
import business.model.Specialty;
import data.dbutil.DbUtil;
import data.dbutil.SqlFunctions;
import data.repositoryinterface.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.object.SqlFunction;

/**
 *
 * @author bsk
 */
public class GroupRepository implements Repository<Group>{

    private static ArrayList<Group> l = new ArrayList<Group>();
    private static SpecialityRepository specRepo = SpecialityRepository.getInstance();
    private static ProfessorRepository pr = ProfessorRepository.getInstance();
    private static final GroupRepository theGroups = new GroupRepository();

    public static GroupRepository getInstance(){
        return theGroups;
    }

    private GroupRepository() {
        for(Specialty s : specRepo.getAll()){
            l.addAll(s.getGroups());
            for(Professor p : pr.getAll())
                for(Group grp : p.getGroups()){
                    for(Group grr : s.getGroups())
                        if(grp.getGroupName().equals(grr.getGroupName())){
                            grp.setSpecialty(grr.getSpecialty());
                        }
            }
        }
    }



    public void add(Group item) {
        try {
            DbUtil dbu = new DbUtil();
            if (SqlFunctions.insert("groups", item.toDbObjectList(), dbu)) {
                l.add(item);
            }
            dbu.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Group> getAll() {
        return l;
    }

    public Group findByName(String name) {
        for(Group g : l)
            if(g.getGroupName().equals(name))
                return g;
        return null;
    }

    public void update(Group item) {
        try {
            DbUtil dbu = new DbUtil();
            SqlFunctions.update("groups", item.toDbObjectList(), "");
            SqlFunctions.delete("students_specializations", "groupId = "+
                    item.toDbObjectListStudents().get(0).getValue());
            SqlFunctions.insert("students_specializations",
                    item.toDbObjectListStudents(), dbu);
            dbu.close();
        } catch (SQLException ex) {
            Logger.getLogger(GroupRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Group item) {
        try {
            if (SqlFunctions.delete("groups", "groupId = " +
                    item.toDbObjectListStudents().get(0).getValue())) {
                l.remove(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

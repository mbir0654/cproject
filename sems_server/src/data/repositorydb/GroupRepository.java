/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data.repositorydb;

import business.model.Group;
import business.model.Professor;
import business.model.Specialty;
import data.repositoryinterface.Repository;
import java.util.ArrayList;
import java.util.List;

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
        l.add(item);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Group item) {
        l.remove(item);
    }
}

package data.repositorydb;

import business.model.*;
import data.repositoryinterface.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bsk
 */
public class AnnouncementRepository implements Repository<Announcement>{
    
	private List<Announcement> l;
    private CourseRepository courses = CourseRepository.getInstance();
    @SuppressWarnings("unused")
	private ProfessorRepository pr = ProfessorRepository.getInstance(); 
    
    private static final AnnouncementRepository announcements = new AnnouncementRepository();
    
    public  static AnnouncementRepository getInstance(){
        return  announcements;
    }
    private AnnouncementRepository(){
    	l = new ArrayList<Announcement>();
        for(Course course : courses.getAll()){
        	l.addAll(course.getAnnouncements());
        	/*for(Professor p : pr.getAll())
                for(Announcement pAnn : p.getAnnouncements()){
                    for(Announcement cAnn : course.getAnnouncements())
                        if(pAnn.getProf().equals(cAnn.getProf())){
                            pAnn = new Announcement(cAnn);
                        }
                }*/
        }
    }

    public void add(Announcement item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Announcement> getAll() {
        return l;
    }

    public Announcement findByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void update(Announcement item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Announcement item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

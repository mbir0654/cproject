package data.repositorydb;

import business.model.Announcement;
import business.model.Course;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: BSK
 * Date: 5/28/11
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnnouncementRepository {
    private List<Announcement> l;
    private CourseRepository courses = CourseRepository.getInstance();

    private static final AnnouncementRepository announcements = new AnnouncementRepository();

    public  static AnnouncementRepository getInstance(){
        return  announcements;
    }
    private AnnouncementRepository(){
        for(Course course:courses.getAll()){
            for(Announcement announcement:course.getAnnouncements())
                l.add(announcement);
        }
    }
}

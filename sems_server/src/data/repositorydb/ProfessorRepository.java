package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import business.model.*;
import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import data.dbutil.MySqlException;
import data.dbutil.SqlFunctions;
import data.repositoryinterface.Repository;
import java.text.SimpleDateFormat;

/**
 * @author otniel
 *
 */
public class ProfessorRepository implements Repository<Professor> {
    private List<Professor> l;
	
    /**
     * retine singura instanta a repositoryului
     */
    private static final ProfessorRepository theTeachers =
        new ProfessorRepository();

    /**
     * Metoda folosita pt accesarea repositoryului
     *
     * @return referinta la singura instanta a repositoryului
     */
    public static ProfessorRepository getInstance(){
        return theTeachers;
    }

    /**
     * Constructor implicit privat, impiedica creara de instante din afara
     */
    private ProfessorRepository(){
        l = new ArrayList<Professor>();
        Professor p;
        try {
            DbUtil dbu = new DbUtil();
            String str = "select u.*,t.teacherTitle from users u inner join " +
            		"teachers t on u.userName = t.userName" +
            		" where u.role = 'prof'";
            ResultSet rs = dbu.getDate(str);
            while (rs.next()){
                p = new Professor();
                p.setFirstName(rs.getString(1));
                p.setLastName(rs.getString(2));
                p.setUserName(rs.getString(3));
                p.setPassword(rs.getString(4));
                p.setTitle(rs.getString(5));
                String gft = "call groups_for_teacher('"+p.getUserName()+"')";
                ResultSet rs1 = dbu.getDate(gft);
                while(rs1.next()){
                    Group g = new Group(rs1.getString(1));
                    g.setSpecialty(null);
                    g.addStudent(null);
                    p.addGroup(g);
                }
                String cft = "call courses_for_teacher('"+p.getUserName()+"')";
                ResultSet rs2 = dbu.getDate(cft);
                while(rs2.next()){
                    Course c = new Course();
                    c.setCod(rs2.getString(1));
                    p.addCourse(c);
                }
                l.add(p);
            }
            dbu.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @see data.repositoryinterface.Repository#add(java.lang.Object)
     */
    @Override
    public void add(Professor item) {
    	List<DbObject> data1 = item.toDbObjectList();
    	List<DbObject> data2 = item.toDbObjectListTeachers();
        try {
            DbUtil dbu = new DbUtil();
            if(SqlFunctions.insert("users", data1,dbu))
                if(SqlFunctions.insert("teachers", data2, dbu)){
                    for(Course c : item.getCourses()){
                        List<DbObject> data3 = item.toDbObjectListTeachCourse(c);
                        SqlFunctions.insert("teachers_spec", data3, dbu);
                    }
                    l.add(item);
                }
            dbu.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @see data.repositoryinterface.Repository#getAll()
     */
    @Override
    public List<Professor> getAll() {
        return l;
    }

    /**
     * @see data.repositoryinterface.Repository#findByName(java.lang.String)
     */
    @Override
    public Professor findByName(String name) {
        for(Professor p : l){
            if(p.getUserName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    /**
     * @see data.repositoryinterface.Repository#update(java.lang.Object)
     */
    @Override
    public void update(Professor item) {
    	List<DbObject> data1 = item.toDbObjectList();
    	List<DbObject> data2 = item.toDbObjectListTeachers();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
            DbUtil dbu = new DbUtil();
            SqlFunctions.update("users", data1, "userName = '"
        		+item.getUserName()+"'");
            SqlFunctions.update("teachers", data2, "userName = '"
        		+item.getUserName()+"'");
            for(Course c : item.getCourses()){
                List<DbObject> data3 = item.toDbObjectListTeachCourse(c);
                SqlFunctions.delete("teachers_spec", "csId = "+data3.get(1).
                        getValue()+" and teacherId ="+data3.get(0).getValue());
                SqlFunctions.insert("teachers_spec", data3, dbu);
                ResultSet rs1 = dbu.getDate("select tsId from teachers_spec" +
                        " where teacherId = "+data3.get(0).getValue()+
                        " and csId="+data3.get(1).getValue());
                if(rs1.next()){
                    Integer tsid = rs1.getInt(1);
                    for(Group g : item.getGroups()){
                        ResultSet rs2 = dbu.getDate("select groupId from groups"
                                +" where name = "+g.getGroupName());
                        if(rs2.next()){
                            Integer grid = rs2.getInt(1);
                            List<DbObject> data4 = new ArrayList<DbObject>();
                            DbObject db1 = new DbObject("tsId",tsid.toString());
                            DbObject db2 = new DbObject("groupId", grid.
                                    toString());
                            data4.add(db1);data4.add(db2);
                            SqlFunctions.delete("teachers_groups", "groupId = "+
                                  grid.toString()+" and tsId="+tsid.toString());
                            SqlFunctions.insert("teachers_groups", data4, dbu);
                        }
                    }
                }
                for(Announcement ann : c.getAnnouncements()){
                    List<DbObject> data5 = new ArrayList<DbObject>();
                    ResultSet rs3 = dbu.getDate("select announcementId from" +
                            " announcement a inner join teachers t on " +
                            "a.teacherId = t.teacherId where userName ='"+
                            item.getUserName()+"'");
                    if(rs3.next()){
                        Integer annid = rs3.getInt(1);
                        DbObject db1 = new DbObject("announcementId", annid.
                                toString());
                        DbObject db2 = new DbObject("teacherId", data3.get(0).
                                getValue());
                        DbObject db3 = new DbObject("csId", data3.get(1).
                                getValue());
                        DbObject db4 = new DbObject("body", ann.
                                getAnnouncement());
                        DbObject db5 = new DbObject("date", sdf.format
                                (ann.getDate()));
                        DbObject db6 = new DbObject("subject",ann.getSubject());
                        data5.add(db1); data5.add(db2); data5.add(db3);
                        data5.add(db4); data5.add(db5); data5.add(db6);
                        SqlFunctions.delete("announcement", "announcementId = "+annid.toString());
                        SqlFunctions.insert("announcement", data5, dbu);
                    }
                }
            }
            dbu.close();
        } catch(MySqlException ex){
            ex.getMessage();
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @see data.repositoryinterface.Repository#delete(java.lang.Object)
     */
    @Override
    public void delete(Professor item) {
    	l.remove(item);
        try {
            SqlFunctions.delete("users", "userName = '"
        		+item.getUserName()+"'");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

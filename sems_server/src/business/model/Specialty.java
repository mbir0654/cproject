package business.model;

import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Specialty implements Serializable {
    private List<Course> courses;
    private List<Group> groups;
    private String name;
    private int numberOfYears;
    private Faculty faculty;

    /**
     * Constructorul implicit
     */
    public Specialty(){
        courses = new ArrayList<Course>();
        groups = new ArrayList<Group>();
        name = "";
        numberOfYears = 3;
    }

    /**
     * verifica daca 2 specialitati sunt identice
     *
     * @param s Specialitatea cu care comparam
     *
     * @return true daca aceasta specialitate este egala cu cea data
     * 		   data ca parametru
     */
    public boolean equals(Specialty s){
        if(name.equalsIgnoreCase(s.getName()))
                return true;
        return false;
    }

    /**
     * @param course este cursul care se adauga in lista care contine cursurile
     * 				care se predau in cadrul acestei specializari
     */
    public void addCourse(Course course) {
        courses.add(course);
    }
    /**
     * @return lista care contine cursurile care se predau in cadrul
     * 			acestei specializari
     */
    public List<Course> getCourses() {
        return courses;
    }
    /**
     * @param name va fi numele specializarii
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return numele specializarii
     */
    public String getName() {
        return name;
    }
    /**
     * @param numberOfYears va fi numarul de ani asociat specializarii
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    /**
     * @return numarul de ani asociat specializarii
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * @param faculty vai fi noua facultate in care exista specializarea
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @return facultatea in cafrul careia exista specializarea
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     *
     * @param groups
     */
    public void addGroup(Group group) {
        groups.add(group);
    }

    /**
     *
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * returneaza un string cu denumirea specializarii
     */
    @Override
    public String toString() {
        return name;
    }

    public List<DbObject> toDboBjectList(){
        List<DbObject> l = new ArrayList<DbObject>();
        DbObject db1 = new DbObject("spName", name);
        DbObject db2 = new DbObject("numberOfYears", numberOfYears+"");
        l.add(db1); l.add(db2);
        return l;
    }

    public List<DbObject> toDboBjectListSF() throws SQLException{
        List<DbObject> l = new ArrayList<DbObject>();
        DbUtil dbu = new DbUtil();
        ResultSet rs;
            DbObject db1 = new DbObject("facultyId", faculty.getId()+"");
            rs = dbu.getDate("select spId from specializations  " +
                    "where spName = '"+name+"'");
            if(rs.next()){
                Integer spid = rs.getInt(1);
                DbObject db2 = new DbObject("spId", spid.toString());
                l.add(db1);l.add(db2);
            }
        return l;
    }
}

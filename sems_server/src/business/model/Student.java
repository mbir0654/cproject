package business.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import java.text.SimpleDateFormat;

/**
 * 
 * @author otniel
 *
 */

public class Student extends User {
	
    private String cnp;
    private String nrMat;
    private Contract contract;
    private List<AssignmentSolution> solutions;
    private Specialty specialty;
    private Group group;
    private Integer year = 0;


    /**
     * Constructorul implicit
     */
    public Student(){
            nrMat = "";
            cnp = "";
            group = new Group();
            contract = new Contract(this);
            solutions = new ArrayList<AssignmentSolution>();
            specialty = new Specialty();
    }

    /**
     * Constructor de copiere
     *
     * @param s este studentul pe care il duplicam
     */
    public Student(Student s){
            super(s);
            nrMat = s.nrMat;
            contract = s.contract;
            solutions = s.solutions;
            specialty = s.specialty;
            year = s.year;
    }

    /**
     * verifica daca 2 studenti sunt identici
     *
     * @param s Studentul cu care comparam
     *
     * @return true daca studentul curent este identic
     * 		   cu cel dat ca parametru
     */
    public boolean equals(Student s){
            if(super.equals(s) && nrMat.equalsIgnoreCase(s.getNrMat()))
                    return true;
            return false;
    }

    /**
     * seteaza Numarul matricol al Studentului
     * @param nrMat va fi noul numar matricol al studentului
     */
    public void setNrMat(String nrMat) {
            this.nrMat = nrMat;
    }

    /**
     * @return numarul matricol al studentului
     */
    public String getNrMat() {
            return nrMat;
    }

    /**
     * @param contract va fi contractul studentului
     */
    public void setContract(Contract contract) {
            this.contract = contract;
    }

    /**
     * @return contractul studentului
     */
    public Contract getContract() {
            return contract;
    }

    /**
     * @param solution este rezolvarea adaugata
     */
    public void addSolution(AssignmentSolution solution) {
            this.solutions.add(solution);
    }

    /**
     * @return lista cu solutiile studentului
     */
    public List<AssignmentSolution> getSolutions() {
            return solutions;
    }

    /**
     * @param specialty va fi noua specialitate a studentului
     */
    public void setSpecialty(Specialty specialty) {
            this.specialty = specialty;
    }

    /**
     * @return specialitatea studentului
     */
    public Specialty getSpecialty() {
            return specialty;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
            this.group = group;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
            return group;
    }

    /**
     *
     * @return anul in care este inmatriculat studentul
     */
    public int getYear() {
            return year;
    }

    /**
     *
     * @param year este anul in care va fi inmatriculat studentul
     */
    public void  setYear(int year){
        this.year = year;
    }

    /**
     *
     * @return cnp-ul studentului
     */
    public String getCnp() {
            return cnp;
    }

    /**
     *
     * @param cnp actualizaeaza cnp-ul studentului
     */
    public void setCnp(String cnp) {
            this.cnp = cnp;
    }


    /**
     *
     * @param e este examenul la care se acorda nota
     *
     * @param g este nota acordata
     */
    public void addGrade(Exam e, Grade g){
        g.setStud(this);
        for(Course c : contract.getCourses()){
            if(c.getExams().contains(e)){
                e.addGrade(g);
            }
        }
    }

    /**
     * genereaza un string cu numele si specializarea studentului
     */
    @Override
    public String toString() {
        return super.toString()+" "+group;
    }

    @Override
    public List<DbObject> toDbObjectList() {
        List<DbObject> l= new ArrayList<DbObject>();
        l.addAll(super.toDbObjectList());
        DbObject db = new DbObject("role", "stud");
        l.add(db);
        return l;
    }


    public List<DbObject> toDbObjectListStud(){
        DbObject db1 = new DbObject("personalCode",cnp);
        DbObject db2 = new DbObject("userName",userName);
        DbObject db3 = new DbObject("serialNumber",nrMat);
        DbObject db4 = new DbObject("year",year.toString());
        List<DbObject> list = new ArrayList<DbObject>();
        list.add(db1); list.add(db2); list.add(db3); list.add(db4);
        return list;
    }
	
    public List<DbObject> toDbObjectListSS() throws SQLException{
            List<DbObject> l = new ArrayList<DbObject>();
            ResultSet rs1,rs2,rs3;
            DbUtil dbu = new DbUtil();
            Integer grid = 0, spid = 0, stid = 0;
            rs1 = dbu.getDate("select groupId from groups where name='"
                    +group.getGroupName()+"'");
            rs2 = dbu.getDate("select spId from specializations where" +
                    " spName='"+specialty.getName()+"'");
            rs3 = dbu.getDate("select studentId from students where" +
                    " userName='"+userName+"'");
            rs1.next();
            grid = rs1.getInt(1);
            System.out.println("grid: "+grid);
            rs2.next();
            spid = rs2.getInt(1);
            System.out.println("spid: "+spid);
            rs3.next();
            System.out.println(rs3.getString(1));
            stid = rs3.getInt(1);
            System.out.println("stid: "+stid);
            DbObject db1 = new DbObject("groupId",grid.toString());
            DbObject db2 = new DbObject("spId",spid.toString());
            DbObject db3 = new DbObject("studentId",stid.toString());
            l.add(db1); l.add(db2); l.add(db3);
            dbu.close();
            return l;
	}
	
    public List<DbObject> toDbObjectListContract() throws SQLException{
        List<DbObject> l = new ArrayList<DbObject>();
        Integer ssid = 0, spid = 0;
        ResultSet rs1,rs2;
        DbUtil dbu = new DbUtil();
        rs1 = dbu.getDate("select ssId from students_" +
                "specializations where studentId in(select studentId from" +
                " students where userName='"+userName+"') limit 1");
        rs2 = dbu.getDate("select spId from specializations where " +
                "spName='"+specialty.getName()+"' limit 1");
        rs1.next();
        ssid = rs1.getInt(1);
        rs2.next();
        spid = rs2.getInt(1);
        DbObject db1 = new DbObject("ssId", ssid.toString());
        DbObject db2 = new DbObject("spId", spid.toString());
        l.add(db1);l.add(db2);
        dbu.close();
        return l;
    }

    public List<DbObject> toDbObjectListContractCourses(Course c)
                                                            throws SQLException{
        List<DbObject> l =  new ArrayList<DbObject>();
        Integer csid = 0, ctid = 0;
        ResultSet rs1,rs2;
        DbUtil dbu = new DbUtil();
        rs1 = dbu.getDate("select csId from specializations_" +
				"courses where courseCode = '"+c.getCod()+"'");
        rs2 = dbu.getDate("select c.contractId from contracts c inner join " +
                "students_specializations ss on c.ssId = ss.ssId inner join " +
                "students s on ss.studentId = s.studentId where " +
                "s.userName = '"+userName+"'");
        rs1.next();
        csid = rs1.getInt(1);
        rs2.next();
        ctid = rs2.getInt(1);
        DbObject db1 = new DbObject("csId", csid.toString());
        DbObject db2 = new DbObject("contractId", ctid.toString());
        l.add(db1);l.add(db2);
        dbu.close();
        return l;
    }

    public List<DbObject> toDbObjectListSolutions(Course c, AssignmentSolution as, Integer assignid) throws SQLException{
        List<DbObject> l = new ArrayList<DbObject>();
        DbUtil dbu = new DbUtil();
        ResultSet rs1,rs2;
        Integer ssid = 0;//assignid = 0, ssid = 0;
        rs1 = dbu.getDate("select ssId from students_" +
                "specializations where studentId in(select studentId from" +
                " students where userName='"+userName+"') limit 1");
        rs1.next();
        ssid = rs1.getInt(1);
        /*rs2 = dbu.getDate("SELECT assignmentId FROM assignments a inner join" +
        " specializations_courses sc on a.csId = sc.csId where " +
        "sc.courseCode = '"+c.getCod()+"'");
        rs2.next();
        assignid = rs2.getInt(1);*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DbObject db1 = new DbObject("ssId", ssid.toString());
        DbObject db2 = new DbObject("assignmentId", assignid.toString());
        DbObject db3 = new DbObject("solution", as.getSolution());
        DbObject db4 = new DbObject("completed", sdf.format(as.getDate()));
        l.add(db1);l.add(db2);l.add(db3);l.add(db4);
        dbu.close();
        return l;
    }
} 

package business.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        return super.toString()+", grupa: "+group.getGroupName();
    }

    @Override
    public List<DbObject> toDbObjectList() {
        return null;
    }


    public List<DbObject> toDbObjectListStud(){
        return null;
    }

    public List<DbObject> toDbObjectListSS() throws SQLException{
            return null;
    }

    public List<DbObject> toDbObjectListContract() throws SQLException{
        return null;
    }
    public List<DbObject> toDbObjectListContractCourses(Course c){
        return null;
    }
    public List<DbObject> toDbObjectListSolutions(Course c, AssignmentSolution as, Integer assignid){
        return null;
    }
}
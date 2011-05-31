/**
 * 
 */
package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.sun.crypto.provider.RSACipher;

import business.model.*;

import data.dbutil.DbUtil;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class FacultyRepository implements Repository<Faculty>{
	
    private List<Faculty> l;
    private StudentRepository sr = StudentRepository.getInstance();
    private ProfessorRepository pr = ProfessorRepository.getInstance();
    private static final FacultyRepository theFaculties =
            new FacultyRepository();
    /**
     *
     * @return singura instanta a repo-ului de facultati
     */
    public static FacultyRepository getInstance(){
            return theFaculties;
    }
    /**
     * Constructor implicit. Initializeaza facultatile din baza de date
     * 	impreuna cu toate legaturile campurilor din ele
     */
    private FacultyRepository(){
        l = new ArrayList<Faculty>();
        Faculty f;
        try {
            /*
             * stabilim conexiunea la baza de date
             */
            DbUtil dbu = new DbUtil();
            /*
             * extragem lista de facultati din baza de date
             */
            String str = "select * from faculties";
            ResultSet rs = dbu.getDate(str);
            /*
             * cat timp exista facultati in lista, construim obiectele
             *  si le adaugam in lista
             */
            while (rs.next()){
                f = new Faculty();
                f.setName(rs.getString("facultyName"));
                f.setAddress(rs.getString("address"));
                int fid = rs.getInt(1);
                /*
                 * extragem din baza de date specializarile
                 * asociate unei facultati
                 */
                String sff = "call specialties_for_faculty("+fid+")";
                ResultSet rs2 = dbu.getDate(sff);
                /*
                 * cat timp exista specializari, construim obiectele
                 * si le adaugam in lista
                 */
                while(rs2.next()){
                    Specialty sp = new Specialty();
                    sp.setFaculty(f);
                    sp.setName(rs2.getString(2));
                    sp.setNumberOfYears(rs2.getInt(3));
                    int spId = rs2.getInt(1);
                    /*
                     *extragem lista de cursuri asociate unei specializari
                     */
                    String cfs = "call courses_for_specialty("+spId+")";
                    ResultSet rs3 = dbu.getDate(cfs);
                    /*
                     * cat timp exista cursuri, construim obiectele
                     * si le adaugam in lista
                     */
                    while(rs3.next()){
                        int csId = rs3.getInt(1);
                        Course c = new Course();
                        c.setSpecializare(sp);
                        c.setName(rs3.getString(2));
                        c.setCod(rs3.getString(3));
                        c.setTip(rs3.getString(4));
                        c.setNumberOfCredits(rs3.getInt(5));
                        c.setSemestrul(rs3.getInt(6));
                        /*
                         *extragem lista de examene pentru un curs,
                         * din baza de date
                         */
                        String exams = "select examId, date, type FROM exams " +
                                        "where csId = "+csId;
                        ResultSet rs4 = dbu.getDate(exams);
                        /*
                         * cat timp exista examene, construim obiectele
                         * si le adaugam in lista
                         */
                        while(rs4.next()){
                            int exId = rs4.getInt(1);
                            Exam e = new Exam(rs4.getDate(2),
                                            rs4.getString(3),c);
                            e.setCourse(c);
                            /*
                             * extragem notele acordate la un examen
                             */
                            String gfe = "call grades_for_exam("+exId+")";
                            ResultSet rs5 = dbu.getDate(gfe);
                            /*
                             * cat timp exista note, construim obiectele
                             * si le adaugam in lista
                             */
                            while(rs5.next()){
                                    Student stud = sr.findByName(rs5.getString(1));
                                    Grade g = new Grade(rs5.getInt(2),stud,e);
                                    e.addGrade(g);
                            }
                            c.addExam(e);
                        }
                        /*
                         * extragem anunturile asociate unui curs,din BD
                         */
                        String afc = "call announce_for_course("+csId+")";
                        ResultSet rs6 = dbu.getDate(afc);
                        /*
                         * cat timp exista anunturi, construim obiectele
                         * si le adaugam in lista
                         */
                        while(rs6.next()){
                            Announcement an = new Announcement(rs6.getString(2)
                                        ,rs6.getString(1),rs6.getDate(3),c);
                            Professor p = pr.findByName(
                                            rs6.getString("userName"));
                            an.setProf(p);
                            p.addAnnouncement(an);
                            c.addAnnouncement(an);
                        }
                        /*
                         * extragem lista de teme asociate unui curs din BD
                         */
                        String asign = "SELECT * FROM assignments " +
                                        "where csId="+csId;
                        ResultSet rs7 = dbu.getDate(asign);
                        /*
                         * cat timp exista teme, construim obiectele
                         * si le adaugam in lista
                         */
                        while(rs7.next()){
                            int asId = rs7.getInt(1);
                            Assignment a = new Assignment(rs7.getString(5),
                                            rs7.getString(3),rs7.getDate(4),c);
                            /*
                             * extragem lista de rezolvari pentru fiecare tema
                             */
                            String sfa = "call solutions_for_assign("+asId+")";
                            ResultSet rs8 =dbu.getDate(sfa);
                            /*
                             * cat timp exista rezolvari, construim obiectele
                             * si le adaugam in lista
                             */
                            while(rs8.next()){
                                Student slStud = sr.findByName(rs8.getString(3));
                                AssignmentSolution assol = new
                                AssignmentSolution(slStud,a,rs8.getDate(2),
                                                rs8.getString(1));
                                a.addSolution(assol);
                                slStud.addSolution(assol);
                            }
                            c.addAssignment(a);
                        }
                        /*
                         * extragemd lista cu materiale pentru curs
                         */
                        String mat ="select fileName from coursematerials " +
                                        "where csId="+csId;
                        ResultSet rs9 = dbu.getDate(mat);
                        /*
                         * cat timp exista materiale, construim obiectele
                         * si le adaugam in lista
                         */
                        while(rs9.next()){
                            CourseMaterial cm = new CourseMaterial();
                            cm.setPath(rs9.getString(1));
                            c.addMaterialCurs(cm);
                        }
                        /*
                         * extragem lista cu profesorii care predau cursul
                         */
                        String tfc = "call teachers_for_course("+csId+")";
                        ResultSet rs0 = dbu.getDate(tfc);
                        /*
                         * cat timp exista profesori, construim obiectele
                         * si le adaugam in lista
                         */
                        while(rs0.next()){
                            Professor p = pr.findByName(rs0.getString(1));
                            c.addProfessor(p);

                        }
                        sp.addCourse(c);
                        }
                        /*
                         * extragem lista cu grupe pentru fiecare specializare
                         */
                        String gfs = "SELECT name, groupId FROM groups where"
                                        +" spId = "+spId;
                        ResultSet rs1 = dbu.getDate(gfs);
                        /*
                         * cat timp exista grupe, construim obiectele
                         * si le adaugam in lista
                         */
                        while (rs1.next()){
                                Group g = new Group();
                                g.setSpecialty(sp);
                                g.setGroupName(rs1.getString(1));
                                /*
                                 *extragem lista cu studentii unei grupe
                                 */
                                String sfg = "call students_for_group("
                                        +rs1.getInt(2)+")";
                                ResultSet rs10 = dbu.getDate(sfg);
                                /*
                                 * cat timp exista studenti, construim obiectele
                                 * si le adaugam in lista
                                 */
                                while(rs10.next()){
                                        int cId = rs10.getInt(1);
                                        Student s = sr.findByName(rs10.getString(6));
                                        s.setGroup(g);
                                        s.setNrMat(rs10.getString(4));
                                        s.setCnp(rs10.getString(5));
                                        s.setYear(rs10.getInt(7));
                                        s.setSpecialty(sp);
                                        /*
                                         * extragem cursurile pentru contractul
                                         * studentului
                                         */
                                        String cfc = "call courses_for_contract("
                                                +cId+")";
                                        Contract contract = new Contract(s);
                                        ResultSet rs11 = dbu.getDate(cfc);
                                        /*
                                         * cat timp exista cursuri, le adaugam in lista
                                         */
                                        while (rs11.next()){
                                                for(Course curs : sp.getCourses()){
                                                        if(curs.getCod().equals
                                                                        (rs11.getString(1))){
                                                                contract.addCourse(curs);
                                                        }
                                                }
                                        }
                                        s.setContract(contract);
                                        g.addStudent(s);
                                }
                                sp.addGroup(g);
                        }
                        f.addSpecialty(sp);
                        }
                        l.add(f);
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
	public void add(Faculty item) {
		l.add(item);
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Faculty> getAll() {
		List<Faculty> r = new ArrayList<Faculty>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#findByName(java.lang.String)
	 */
	@Override
	public Faculty findByName(String name) {
		for(Faculty f:l){
			if(f.getName().equalsIgnoreCase(name))
				return f;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Faculty item) {
	}

	/**
	 * 
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Faculty item) {
		l.remove(item);		
	}

}
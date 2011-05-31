package server;

import business.model.*;
import data.dbutil.DbUtil;
import data.repositorydb.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");
        try {
            DbUtil dbu = new DbUtil();
            ResultSet rs1 = dbu.getDate("select * from courses");
            while(rs1.next())
            System.out.println(rs1.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(SemsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Course c = new Course("Ingineria SistemelorSoft", 6, null);
        c.setSpecializare(SpecialityRepository.getInstance().findByName("informatica"));
        c.generateCod();
        for (Professor p : ProfessorRepository.getInstance().getAll()){
            c.addProfessor(p);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        c.addAnnouncement(new Announcement("text anunt", "titlu anunt nou", new Date(), c));
        try {
            c.addAssignment(new Assignment("titlu tema noua", "cerinta temei", sdf.parse("08-06-2011"), c));
            c.addExam(new Exam(sdf.parse("08-06-2011"), "partial", c));
        } catch (ParseException ex) {
            Logger.getLogger(SemsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        CourseMaterial nmc = new CourseMaterial();
        nmc.setPath("~/sems/cproject/sems_server/doc/Documentatie\\ PC/221-II (1).docx");
        c.addMaterialCurs(nmc);
        System.out.println(c.getName());
        c.setTip("OPTIONAL");
        CourseRepository.getInstance().add(c);
    }
}

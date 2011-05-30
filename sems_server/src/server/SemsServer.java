package server;

import business.model.Administrator;
import business.service.AppService;
import data.dbutil.DbUtil;
import data.repositorydb.AdministratorRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author myh
 */
public class SemsServer {
    public static void main(String args[]) throws SQLException {
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                "classpath:server/serverContext.xml");

        Administrator a = new Administrator();
        a.setFirstName("Otniel");
        a.setLastName("Nicola");
        a.setUserName("oti");
        a.setPassword("1a1dc91c907325c69271ddf0c944bc72");
        AdministratorRepository.getInstance().add(a);
        
        ResultSet rs = new DbUtil().getDate("select* from users");
        while(rs.next())
            System.out.println(rs.getString(1));
    }
}

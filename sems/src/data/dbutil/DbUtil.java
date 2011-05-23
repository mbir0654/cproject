package data.dbutil;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author BSK
 */
public class DbUtil {
    Connection con;
    public DbUtil() throws SQLException{
        try {
            //Database URL	jdbc:mysql://localhost/gestiunebani
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc221","root", "");
    }
    public ResultSet getDate(String str) throws SQLException{

        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery(str);
        return rs;
    }
    public int makeUpdate(String str) throws SQLException{
        Statement st = con.createStatement();
        int rasp = st.executeUpdate(str);
        return rasp;
    }


}

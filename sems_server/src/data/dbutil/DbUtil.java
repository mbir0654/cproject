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
 * @author 8i
 */
public class DbUtil {
    Connection con;
    
    /**
     * Constructorul implicit in care se realizeaza conexiunea la baza de date
     * dorita pe care vrem s-o accesam.
     * 
     * @throws SQLException
     */
    public DbUtil() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = DriverManager.getConnection
        	("jdbc:mysql://localhost:3306/pc221","root", "");
    }
    
    /**
     * Metoda prin care se face i interogare in baza de date 
     * 
     * @param str este comanda <b>select</b> de interogare
     * 
     * @return o tabela de rezultate sub forma unui obiect <b>ResultSet</b>
     * 
     * @throws SQLException
     */
    public ResultSet getDate(String str) throws SQLException{

        ResultSet rs;
        Statement st = con.createStatement();
        rs = st.executeQuery(str);
        return rs;
    }
    
    /**
     * Metoda prin care se modifica continutul unei tabele
     * 
     * @param str contine instructiuni DML: <b>insert</b>, <b>update</b>
     * 			sau <b>delete</b> sau o instructiune de definire (DDL)
     * 
     * @return in cazul instructiunilor DML intoarce numarul de randuri 
     * 				afectate de instructiuni </br>
     * 		   in cazul instructiunilor DDL returneaza 0  
     * 
     * @throws SQLException
     */
    public int makeUpdate(String str) throws SQLException{
        Statement st = con.createStatement();
        int rasp = st.executeUpdate(str);
        return rasp;
    }
}
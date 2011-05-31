package data.dbutil;



import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 8i
 */
public abstract class SqlFunctions{
    /**
     * Executa un insert pe o tabela in baza de date
     *
     * @param tableName este numele tabelei pe care se face insert
     * @param data este lista de {numeColoana,denumire coloana}
     * @see DbObject#DbObject(java.lang.String, java.lang.String)
     * @return true daca s-a efectuat operatia in baza de date si fals in caz
     * contrar
     * @throws SQLException
     */
    public static boolean insert(String tableName, List<DbObject> data, DbUtil dbu) throws SQLException{
        try {
            String f = "";
            String v = "";
            String ff = "";
            String vv = "";
            for (DbObject dbo : data) {
                if (!ff.equals("")) {
                    ff += ",";
                }
                ff += dbo.getField();
                if (!vv.equals("")) {
                    vv += ",";
                }
                vv += "'" + dbo.getValue() + "'";
            }
            f += ff;
            v += vv;
            String s = "insert into " + tableName + "(" + f + ") values(" + v + ")";
            System.out.println(s);
            if (dbu.makeUpdate(s) > 0) {
                System.out.println("inserare cu succes!");
                return true;
            }

        }
        catch(MySQLIntegrityConstraintViolationException ex){
            System.out.println(ex.getMessage());
            throw new MySqlException();
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
        System.out.println("obiectul exista deja in baza de date");
        throw new MySqlException();
        }
        return false;
    }


    /**
     * Executa un update in baza de date
     *
     * @param tableName este numele tabelei pe care se face update
     * @param data o lista de {numeColoana,denumire coloana}
     * @param where este conditia dupa care se face update
     * @see DbObject#DbObject(java.lang.String, java.lang.String)
     * @return true daca s-a efectuat operatia in baza de date si fals in caz
     * contrar
     * @throws SQLException
     */
    public static boolean update(String tableName, List<DbObject> data,
                             String where) throws SQLException {
        try{
            //String f = "";
            String ff = "";
            for (DbObject dbo : data) {
                if (!ff.equals("")) {
                    ff += ", ";
                }
                ff += dbo.getField()+" = '"+dbo.getValue()+"'";
            }
            String s = "update " + tableName +" set "+ ff + " where " + where;
            DbUtil dbu = new DbUtil();
            if(dbu.makeUpdate(s) > 0){
                dbu.close();
                return true;
            }dbu.close();
        }catch(MySQLIntegrityConstraintViolationException ex){
            System.out.println(ex.getMessage());
            throw new MySqlException();
        }
        return false;
    }

    /**
     * Executa un delete din baza de date
     *
     * @param tableName este numele tabelei din care se doreste stergerea
     * @param where este conditia dupa care se face stergerea
     * @return true daca s-a efectuat operatia in baza de date si fals in caz
     * contrar
     */
    public static boolean delete(String tableName, String where)
                                throws SQLException{
        DbUtil dbu = new DbUtil();
        if(dbu.makeUpdate("delete from "+tableName+" where "+where) > 0)
        {dbu.close();
            return true;}
        dbu.close();
        return false;
    }
}
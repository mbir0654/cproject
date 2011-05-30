package data.dbutil;

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
    public static boolean insert(String tableName, List<DbObject> data)
                                   throws SQLException{
        String f = "", v = "";
        for(DbObject dbo : data){
            f += dbo.getField();
            v += "'"+dbo.getValue()+"'";
            if(data.iterator().hasNext())
                f += ",";
        }
        String s = "insert into table"+tableName+"("+f+") values("+v+")";
        DbUtil dbu = new DbUtil();
        if(dbu.makeUpdate(s) > 0)
            return true;
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
                                String where) throws SQLException{
        String f = "";
        for(DbObject dbo : data){
            f += dbo.getField()+" = "+dbo.getValue();
            if(data.iterator().hasNext())
                f += ", ";
        }
        String s = "update table "+tableName+f+"where"+where;
        DbUtil dbu = new DbUtil();
        if(dbu.makeUpdate(s) > 0)
            return true;
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
            return true;
        return false;
    }
}  
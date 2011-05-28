package data.dbutil;

import business.model.DbObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

  public abstract class SqlFunctions{
      public static boolean insert(String tableName, ArrayList<DbObject> data)
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
  }
  
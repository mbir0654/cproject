package data.dbutil;


/**
 * Tip de data care retine un camp care reprezinta numele unei coloane
 * si o valoare sub forma de stringuri
 *
* @author 8i
*/
public class DbObject{
    String field;
    String value;

    /**Constructor parametrizat
     *
     * @param field este numele coloanei
     * @param value este valoare care se doreste a fi introdusa
     * in coloana respectiva
     */
    public DbObject(String field, String value){
        this.field = field;
        this.value = value;
    }
    
    public String getField(){
        return this.field;
    }
    
    public String getValue(){
         return this.value;
    }
    
    @Override
    public String toString(){
        return field+" "+value;
    }
    
    public void setField(String field){
        this.field = field;
    }
    
    public void setValue(String value){
        this.value = value;
    }
}

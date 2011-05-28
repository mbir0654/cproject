package business.model;


/**
* @author 8i
*/
public class DbObject{
    String field;
    String value;
    
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

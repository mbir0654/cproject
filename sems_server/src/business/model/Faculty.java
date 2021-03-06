package business.model;

import data.dbutil.DbObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable {
    private int id;
    private String name = "";
    private String address = "";
    private ArrayList<Specialty> specialties = new ArrayList<Specialty>();

    /**
     * Constructorul implicit
     */
    public Faculty() {
    }

    /**
     * verifica daca 2 facultati sunt identice
     *
     * @param f este facultatea cu care comparam
     *
     * @return true daca facultatea curenta este identica
     * 	 	   cu dea data ca parametru
     */
    public boolean equals(Faculty f){
        if(this.id == f.getId())
                return true;
        return false;
    }

    /**
     * @param name va fi numele facultatii
     */		// TODO Auto-generated method stub

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    /**
     * @return numele facultatii
     */
    public String getName() {
            return name;
    }

    /**
     * @param address va fi adresa facultatii
     */
    public void setAddress(String address) {
            this.address = address;
    }

    /**
     * @return adresa facultatii
     */
    public String getAddress() {
            return address;
    }

    /**
     * @param specialtie este specialitatea ce va fi adaugata in lista cu
     * 		specializarile facultatii
     */
    public void addSpecialty(Specialty specialty) {
            specialties.add(specialty);
    }

    /**
     * @return lista cu specializarile facultatii
     */
    public ArrayList<Specialty> getSpecialties() {
            return specialties;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
            return name+" "+address;
    }

    public List<DbObject> toDbObjectList(){
        List<DbObject> l = new ArrayList<DbObject>();
        DbObject db1 = new DbObject("facultyName", name);
        DbObject db2 = new DbObject("address", address);
        l.add(db1);l.add(db2);
        return l;
    }
}

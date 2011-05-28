package data.repositorydb;

import business.model.Contract;
import data.repositoryinterface.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CLJ
 * Date: 5/28/11
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContractRepository implements Repository<Contract>{
    private List<Contract> l;
    private StudentRepository students = StudentRepository.getInstance();

    private static final ContractRepository contracts  = new ContractRepository();

    public static ContractRepository getInstance(){
        return  contracts;
    }
    private ContractRepository(){
        //nu o mai fac:D
    }

    public void add(Contract item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Contract> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Contract findByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void update(Contract item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Contract item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

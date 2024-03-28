package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.EmpOnProjDAO;
import cmc.WebJava.relations.EmpOnProj;
import org.springframework.stereotype.Repository;

@Repository
public class EmpOnProjDAOimplement extends DefaultDAOimplement<EmpOnProj, Long> implements EmpOnProjDAO {

    public EmpOnProjDAOimplement() {
        super(EmpOnProj.class);
    }
}
package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.RoleHistoryDAO;
import cmc.WebJava.relations.RoleHistory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleHistoryDAOimplement extends DefaultDAOimplement<RoleHistory, Long> implements RoleHistoryDAO {

    public RoleHistoryDAOimplement() {
        super(RoleHistory.class);
    }
}
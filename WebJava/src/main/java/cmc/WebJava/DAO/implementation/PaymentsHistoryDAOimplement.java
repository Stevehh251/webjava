package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.PaymentsHistoryDAO;
import cmc.WebJava.relations.PaymentsHistory;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentsHistoryDAOimplement extends DefaultDAOimplement<PaymentsHistory, Long> implements PaymentsHistoryDAO {

    public PaymentsHistoryDAOimplement() {
        super(PaymentsHistory.class);
    }
}
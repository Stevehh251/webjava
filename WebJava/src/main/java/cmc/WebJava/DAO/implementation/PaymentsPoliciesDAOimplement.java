package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.PaymentsPoliciesDAO;
import cmc.WebJava.relations.PaymentsPolicies;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentsPoliciesDAOimplement extends DefaultDAOimplement<PaymentsPolicies, Long> implements PaymentsPoliciesDAO {

    public PaymentsPoliciesDAOimplement() {
        super(PaymentsPolicies.class);
    }
}
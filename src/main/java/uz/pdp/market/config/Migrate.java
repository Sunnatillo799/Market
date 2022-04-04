package uz.pdp.market.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import uz.pdp.market.utils.HibernateUtil;

public class Migrate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

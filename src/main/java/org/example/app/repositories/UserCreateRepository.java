package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
// Interface Session. Основний інтерфейс часу виконання між
// Java програмою і Hibernate. Представляє поняття контексту збереження,
// набору екземплярів керованих об'єктів, пов'язаних з логічною транзакцією.
//https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Session.html
import org.hibernate.Session;
// Interface Transaction представляє локальну транзакцію ресурсу,
// де локальна транзакція інтерпретується Hibernate як будь-яка
// транзакція, що знаходиться під управлінням Hibernate.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Transaction.html
import org.hibernate.Transaction;
// Interface MutationQuery. У контексті активної session представляє
// запит на зміну, що виконується, тобто insert, update, або delete.
// Це спрощена версія Query, що надає лише методи, що стосуються
// запитів на зміну.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/MutationQuery.html
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/QueryProducer.html#createMutationQuery(java.lang.String)
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (userName, firstName, lastName, email) " +
                    "VALUES (:userName, :firstName, :lastName, :email)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("email", user.getEmail());
            query.executeUpdate();

            // Транзакція виконується
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
         } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}

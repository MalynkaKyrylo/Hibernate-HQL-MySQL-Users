package org.example.app.utils;

import org.example.app.entities.User;

// Interface Session. Основний інтерфейс часу виконання між
// Java програмою і Hibernate. Представляє поняття контексту збереження,
// набору екземплярів керованих об'єктів, пов'язаних з логічною транзакцією.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Session.html
import org.hibernate.Session;
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/Query.html
import org.hibernate.query.Query;

// Клас-перевірка наявності id у БД
public class IdChecker {

    public static boolean isIdExists(User user) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Перевірка наявності об'єкту за певним id
            user = session.get(User.class, user.getId());

            if (user != null) {
                Query<User> query = session.createQuery("FROM Contact", User.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return user != null;
        }
    }
}

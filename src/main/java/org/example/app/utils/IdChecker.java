package org.example.app.utils;

import org.example.app.entities.Contact;

// Interface Session. Основний інтерфейс часу виконання між
// Java програмою і Hibernate. Представляє поняття контексту збереження,
// набору екземплярів керованих об'єктів, пов'язаних з логічною транзакцією.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/Session.html
import org.hibernate.Session;
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/query/Query.html
import org.hibernate.query.Query;

// Клас-перевірка наявності id у БД
public class IdChecker {

    public static boolean isIdExists(Contact contact) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Перевірка наявності об'єкту за певним id
            contact = session.get(Contact.class, contact.getId());

            if (contact != null) {
                Query<Contact> query = session.createQuery("FROM Contact", Contact.class);
                query.setMaxResults(1);
                query.getResultList();
            }
            return contact != null;
        }
    }
}

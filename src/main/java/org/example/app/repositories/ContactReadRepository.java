package org.example.app.repositories;

import org.example.app.entities.Contact;
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

import java.util.*;

public class ContactReadRepository {

//    public List<Contact> readContacts() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM Contact", Contact.class).list();
//        } catch (Exception e) {
//            // Якщо помилка – повертаємо порожню колекцію
//            return Collections.emptyList();
//        }
//    }

    public List<Contact> readContacts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;
            // Транзакція стартує
            transaction = session.beginTransaction();
            List<Contact> contacts =
                    session.createQuery("FROM Contact", Contact.class).list();
            // Транзакція виконується
            transaction.commit();
            return contacts;
        } catch (Exception e) {
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}


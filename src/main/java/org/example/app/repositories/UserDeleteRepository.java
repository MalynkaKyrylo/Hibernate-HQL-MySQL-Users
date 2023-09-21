package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserDeleteRepository {

    public String deleteContact(User user) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(user)) {
            return deleteContactById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    public String deleteContactById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            // Видалення об'єкту
            user = session.get(User.class, user.getId());

            if (user != null) {
                String hql = "DELETE FROM Contact WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hql);
                query.setParameter("id", user.getId());
                query.executeUpdate();
            }
            // Транзакція виконується
            transaction.commit();
            return Constants.DATA_DELETE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
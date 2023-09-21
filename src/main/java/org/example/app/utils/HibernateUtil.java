package org.example.app.utils;

import org.example.app.entities.User;
// Interface SessionFactory є екземпляром Hibernate.
// Він підтримує метамодель часу виконання, що представляє постійні
// об'єкти, їх атрибути, їх асоціації та їх зіставлення з таблицями реляційної
// бази даних, і навіть конфігурацію, що впливає на поведінку Hibernate під час
// виконання, та екземпляри служб, які Hibernate необхідно виконувати свої обов'язки.
// https://docs.jboss.org/hibernate/orm/6.2/javadocs/org/hibernate/SessionFactory.html
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
// Class Properties - службовий клас, призначений
// для обробки файлів конфігурації, де властивості (прості параметри)
// зберігаються у вигляді пар ключ-значення поза скомпільованим кодом.
// https://docs.oracle.com/javase/8/docs/api/java/util/Properties.html
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = getConfiguration();
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration
                        .buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, Constants.DB_DRIVER);
        settings.put(Environment.URL, Constants.DB_URL);
        settings.put(Environment.USER, Constants.DB_USER);
        settings.put(Environment.PASS, Constants.DB_PASS);
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        configuration.setProperties(settings);
        return configuration;
    }
}

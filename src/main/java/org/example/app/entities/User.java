package org.example.app.entities;

import jakarta.persistence.*;

// Клас-модель об'єкта, що є записом у БД.
// Набір змінних (властивостей об'єкта) відповідає
// стовпцям у таблиці БД.
//
// @Entity
// Вказує, що клас є сутністю.
//
// @Table(name = "contacts1")
// Вказує таблицю в БД, з якою зіставлено цей об'єкт.
@Entity
@Table(name = "users1")
public class User {

    // @Id
    // Визначає первинний ключ об'єкта.
    //
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Для автоматичного генерування значення первинного ключа.
    // Визначає стратегію генерації значень первинних ключів.
    // GenerationType.IDENTITY вказує, що первинні ключі для сутності
    // повинні призначатися, використовуючи стовпець ідентифікації БД.
    // Вони автоматично збільшуються.
    //
    // @Column (name = "id")
    // Вказує зіставлення стовпців в БД.
    // Атрибут name використовується для вказівки імені стовпця таблиці.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Тут, найменування стовпця в БД
    // не збігається із найменуванням змінної.
    // Атрибут name вирішує проблему.
    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String userName, String firstName, String lastName, String email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

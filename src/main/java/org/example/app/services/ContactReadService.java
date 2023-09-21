package org.example.app.services;

import org.example.app.entities.Contact;
import org.example.app.repositories.ContactReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactReadService {

    ContactReadRepository repository;

    public ContactReadService(ContactReadRepository repository) {
        this.repository = repository;
    }

    public String readContacts() {

        // Отримуємо дані у колекцію.
        List<Contact> list = repository.readContacts();

        // Якщо колекція не null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (list != null) {
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.х.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(contact.getId())
                                .append(", ")
                                .append(contact.getFirstName())
                                .append(" ")
                                .append(contact.getLastName())
                                .append(", ")
                                .append(contact.getPhone())
                                .append(", ")
                                .append(contact.getEmail())
                                .append("\n")
                );
                return "\n______ CONTACTS ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}

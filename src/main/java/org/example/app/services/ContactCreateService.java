package org.example.app.services;

import org.example.app.entities.Contact;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.ContactCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmailValidator;
import org.example.app.utils.PhoneValidator;

import java.util.HashMap;
import java.util.Map;

public class ContactCreateService {

    ContactCreateRepository repository;

    public ContactCreateService(ContactCreateRepository repository) {
        this.repository = repository;
    }

    public String createContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createContact(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);

        if (data[1].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);

        if (PhoneValidator.isPhoneValid(data[2]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (EmailValidator.isEmailValid(data[3]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private Contact convertData(String[] data) {
        Contact contact = new Contact();
        contact.setFirstName(data[0]);
        contact.setLastName(data[1]);
        contact.setPhone(data[2]);
        contact.setEmail(data[3]);
        return contact;
    }
}

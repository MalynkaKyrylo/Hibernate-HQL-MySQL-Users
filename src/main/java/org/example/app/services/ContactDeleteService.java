package org.example.app.services;

import org.example.app.entities.Contact;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.ContactDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class ContactDeleteService {

    ContactDeleteRepository repository;

    public ContactDeleteService(ContactDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.deleteContact(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private Contact convertData(String[] data) {
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(data[0]));
        return contact;
    }
}

package org.example.app.controllers;

import org.example.app.services.ContactDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.views.ContactDeleteView;

public class ContactDeleteController {

    ContactDeleteService service;
    ContactDeleteView view;

    public ContactDeleteController(ContactDeleteService service, ContactDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteContact() {
        view.getOutput(service.deleteContact(view.getData()));
        AppStarter.startApp();
    }
}

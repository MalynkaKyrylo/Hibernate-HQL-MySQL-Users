package org.example.app.controllers;

import org.example.app.services.ContactCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.ContactCreateView;

public class ContactCreateController {

    ContactCreateView view;
    ContactCreateService service;

    public ContactCreateController(ContactCreateService service, ContactCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createContact() {
        view.getOutput(service.createContact(view.getData()));
        AppStarter.startApp();
    }
}

package org.example.app.controllers;

import org.example.app.services.ContactReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.ContactReadView;


public class ContactReadController {

    ContactReadService service;
    ContactReadView view;

    public ContactReadController(ContactReadService service, ContactReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readContacts() {
        view.getOutput(service.readContacts());
        AppStarter.startApp();
    }
}

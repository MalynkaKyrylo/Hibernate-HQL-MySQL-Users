package org.example.app.views;

import java.util.Scanner;

public class ContactCreateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter first name: ";
        System.out.print(title);
        String firstName = scanner.nextLine().trim();

        title = "Enter last name: ";
        System.out.print(title);
        String lastName = scanner.nextLine().trim();

        title = "Enter phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine().trim();

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[]{firstName, lastName, phone, email};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}

package com.mateusflores;

import controllers.UserController;
import model.entities.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Mateus", "99999-9999", "user@gmail.com", "test address");
        UserController controller = new UserController();

        controller.createUser(user);
    }
}
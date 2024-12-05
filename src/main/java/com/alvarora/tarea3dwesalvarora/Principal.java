package com.alvarora.tarea3dwesalvarora;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import com.alvarora.tarea3dwesalvarora.view.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Principal implements CommandLineRunner {

    @Autowired
    private Controller controller;

    @Autowired
    private MainMenu mainMenu;

    @Override
    public void run(String... args) throws Exception {
        mainMenu.menuPrincipal();
    }
}

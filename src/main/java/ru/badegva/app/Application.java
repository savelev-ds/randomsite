package ru.badegva.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    //todo add metric for select regular hrefs
    //todo add metric for select partner hrefs

    //todo add metric for select regular href duration
    //todo add metric for select partner href duration

    //todo can add empty string

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

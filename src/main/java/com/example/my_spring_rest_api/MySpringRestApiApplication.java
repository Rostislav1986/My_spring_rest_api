package com.example.my_spring_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class MySpringRestApiApplication {
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/login");
    }
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MySpringRestApiApplication.class, args);
        openHomePage();
    }

}

package com.aircraftdemo1.aircraftdemo1;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aircraftdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Aircraftdemo1Application.class, args);
        System.out.println("Herkese selam ");
    }

}

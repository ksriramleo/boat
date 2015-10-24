package com.hackathon.boat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by srirkumar on 10/24/2015.
 */
@SpringBootApplication
@ComponentScan("com.hackathon.boat")
public class BoatDataService {

    public static void main(String [] args) {
        SpringApplication.run(BoatDataService.class);
    }


}

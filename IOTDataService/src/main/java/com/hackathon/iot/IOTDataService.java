package com.hackathon.iot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by srirkumar on 10/24/2015.
 */
@SpringBootApplication
@ComponentScan("com.hackathon.iot")
public class IOTDataService {

    public static void main(String [] args) {
        SpringApplication.run(IOTDataService.class);
    }


}

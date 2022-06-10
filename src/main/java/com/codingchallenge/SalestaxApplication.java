package com.codingchallenge;

import com.codingchallenge.file.reader.exception.WrongInputFormatException;
import com.codingchallenge.order.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SalestaxApplication implements CommandLineRunner {

    @Autowired
    private ShoppingBasketService service;

    public static void main(String[] args) {
        SpringApplication.run(SalestaxApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException, WrongInputFormatException {
        service.processOrder(args);
    }

}

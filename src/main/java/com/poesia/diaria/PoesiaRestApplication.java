package com.poesia.diaria;

import com.poesia.diaria.repository.CoctelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class PoesiaRestApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
    }
    public static void main(String[] args) {
        SpringApplication.run(PoesiaRestApplication.class, args);


    }
}
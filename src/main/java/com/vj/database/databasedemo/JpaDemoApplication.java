package com.vj.database.databasedemo;

import com.vj.database.databasedemo.entity.Person;
import com.vj.database.databasedemo.jdbc.PersonJdbcDao;
import com.vj.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("find by id -> {} "+personJpaRepository.findById(10001));
        logger.info("inserting 10005 -> {}", personJpaRepository.insert(new Person(10005, "AJAJ", "HYD", new Date())));
        logger.info("updating 10003 -> {}", personJpaRepository.update(new Person(10003, "SSSS", "HYD", new Date())));
        personJpaRepository.deleteById(10001);
        logger.info("All users -> {}", personJpaRepository.findAll());

    }
}

package com.vj.database.databasedemo;

import com.vj.database.databasedemo.entity.Person;
import com.vj.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", personJdbcDao.findAll());
        logger.info("user id 10001 -> {}", personJdbcDao.findById(10001));
        logger.info("User whose city is Bangalore -> {} ", personJdbcDao.findByCity("Bangalore"));

        logger.info("delete whose city is -> {} ", personJdbcDao.deleteByLoc("Bangalore"));

        logger.info("inserting 10005 -> {}", personJdbcDao.insert(new Person(10005, "AJAJ", "HYD", new Date())));

        logger.info("updating 10003 -> {}", personJdbcDao.update(new Person(10003, "SSSS", "HYD", new Date())));
    }
}

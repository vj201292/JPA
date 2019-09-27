package com.vj.database.databasedemo.jdbc;

import com.vj.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject
                ("select * from person where id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findByCity(String location) {
        return jdbcTemplate.query("select * from person where location=?",
                new Object[]{location},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteByLoc(String location) {
        return jdbcTemplate.update("delete from person where location=?",
                new Object[]{location});
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into person(id,name,location,birth_date)"
                        + "values(?,?,?,?)",
                new Object[]{
                        person.getId(), person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person " +
                        " set name= ?,location = ?,birth_date = ? "
                        + " where id = ?",
                new Object[]{
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId()});
    }
}

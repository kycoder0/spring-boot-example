package com.trevdev.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;


@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO person (name, id) VALUES('trevor r', '" + UUID.randomUUID().toString() + "')";
		int rows = jdbcTemplate.update(sql);
		System.out.println(rows);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}

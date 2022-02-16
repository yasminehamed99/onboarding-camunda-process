package com.zatca.lookups;

import com.zatca.lookups.entity.ErrorMessage;
import com.zatca.lookups.repository.ErrorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
@Slf4j
public class LookupsApplication {

//	private EntityManagerFactory entityManagerFactory;
//	private EntityManager entityManager;

	@Autowired
	private ErrorRepo errorRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(LookupsApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() throws IOException {

		List<ErrorMessage> errorMessages = errorRepo.findAll();
		if (ObjectUtils.isEmpty(errorMessages)) {
			File file = new File("/resources/data.sql");
			String insertStatements= new String(Files.readAllBytes(file.toPath()));
			jdbcTemplate.execute(insertStatements);
		}

		return args -> {
			log.info("Command Line Runner Executed");
		};
	}

}

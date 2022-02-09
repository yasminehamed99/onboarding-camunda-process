package com.zatca.lookups;

import com.zatca.lookups.entity.configuration.taxpayerData.TaxpayerData;
import com.zatca.lookups.repository.TaxpayerDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class LookupsApplication {

//	private EntityManagerFactory entityManagerFactory;
//	private EntityManager entityManager;

	@Autowired
	private TaxpayerDataRepo taxpayerDataRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(LookupsApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() throws IOException {

		List<TaxpayerData> taxpayerData  = taxpayerDataRepo.findAll();
		if (ObjectUtils.isEmpty(taxpayerData)) {
			File file = ResourceUtils.getFile("classpath:data.sql");
			String insertStatements= new String(Files.readAllBytes(file.toPath()));
			jdbcTemplate.execute(insertStatements);
		}

		return args -> {
			log.info("Command Line Runner Executed");
		};
	}

}

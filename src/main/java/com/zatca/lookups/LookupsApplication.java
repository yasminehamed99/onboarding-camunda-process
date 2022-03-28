package com.zatca.lookups;

import com.zatca.lookups.entity.ErrorMessage;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.repository.ErrorRepo;
import com.zatca.lookups.repository.LookupRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class LookupsApplication {

//	private EntityManagerFactory entityManagerFactory;
//	private EntityManager entityManager;

	@Autowired
	private ErrorRepo errorRepo;

	@Autowired
	private LookupRepo lookupRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${root.admin.config.code}")
	private String adminConfigRootCode;

	public static void main(String[] args) {
		SpringApplication.run(LookupsApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() throws IOException {

		List<ErrorMessage> errorMessages = errorRepo.findAll();
		Optional<Lookup> root = lookupRepo.findByCode(adminConfigRootCode);
		if (ObjectUtils.isEmpty(root)) {
			File file = new File("/resources/data.sql");
			String insertStatements= new String(Files.readAllBytes(file.toPath()));
			jdbcTemplate.execute(insertStatements);
		}

		if (ObjectUtils.isEmpty(errorMessages)) {
			File file = new File("/resources/messagesData.sql");
			String insertStatements= new String(Files.readAllBytes(file.toPath()));
			jdbcTemplate.execute(insertStatements);
		}

		return args -> {
			log.info("Command Line Runner Executed");
		};
	}

	@Bean
	RestTemplate restTemplate() {return new RestTemplate();}

}

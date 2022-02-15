package com.zatca.lookups;

import com.zatca.lookups.api.v1.request.RequestLookupDto;
import com.zatca.lookups.entity.Lookup;
import com.zatca.lookups.entity.LookupStatus;
import com.zatca.lookups.exception.NotFoundBusinessException;
import com.zatca.lookups.repository.LookupRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = LookupsApplication.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class LookupsApplicationTests implements IntegrationAbstractTest {

	@Autowired
	private LookupRepo lookupRepo;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeAll
	public void beforeAll() {

		Lookup root = new Lookup();
		root.setLookupStatus(LookupStatus.ENABLED);
		root.setGroup("Root");
		root.setCode("ROOT");

		lookupRepo.save(root);
	}

	@Test
	public void TEST_CREATE_NEW_LOOKUP() throws Exception {

		Lookup rootLookup = lookupRepo.findByCode("ROOT_CODE").orElseThrow(() ->
				new NotFoundBusinessException("Can't find the root lookup"));
		RequestLookupDto dto = makeRandomLookupRequest(rootLookup.getCode());

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/lookups/v1/lookup")
						.contentType(MediaType.APPLICATION_JSON)
						.content(makeItString(dto))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andReturn();

		Assert.isTrue(!lookupRepo.findByCode(dto.getCode()).isEmpty(),
				"Can't find the created lookup");

		MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.
				get("/api/lookups/v1/rootLookupByDepth").param("depth", "0"))
				.andDo(print()).andExpect(status().is2xxSuccessful()).andReturn();

		System.out.print(mvcResult1);
	}
}
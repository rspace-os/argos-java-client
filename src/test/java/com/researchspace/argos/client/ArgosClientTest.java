package com.researchspace.argos.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.researchspace.argos.client.ArgosClient;
import com.researchspace.argos.model.ArgosDMP;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.Criteria;
import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.TableRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class ArgosClientTest {

		private ArgosClientImpl argosClientImpl;
		private MockRestServiceServer mockServer;

		@BeforeEach
		public void startUp() throws MalformedURLException {
			argosClientImpl = new ArgosClientImpl(new URL("https://devel.opendmp.eu/srv/api/public"));
			mockServer = MockRestServiceServer.createServer(argosClientImpl.getRestTemplate());
		}

		@AfterEach
		public void tearDown() {
		}

		@Test
		public void listPlansTest() throws IOException {
			mockServer.expect(requestTo(containsString("public/dmps")))
				        .andExpect(method(HttpMethod.POST))
				        .andRespond(withSuccess("{\"payload\": {\"totalCount\": 1, \"data\": [ { \"id\": \"78f64f2d-8686-4dad-8d97-cb7763dbba27\", \"label\": \"Dmp For Project : 00332/EI\", \"grant\": \"00332/EI\", \"createdAt\": 1560252575000, \"modifiedAt\": 1560254599000 } ]}}", MediaType.APPLICATION_JSON));
				try {
					TableRequest request = new TableRequest(10, 0, new Criteria(null, null, null, null));
					DataTableData<ArgosDMPListing> list = argosClientImpl.listPlans(request);
					assertEquals(list.getData().size(), 1);
					assertEquals(list.getData().get(0).label, "Dmp For Project : 00332/EI");
				} catch (MalformedURLException | URISyntaxException e) {
					fail("argosClient.listPlans threw an exception.");
				}
		}

		@Test
		public void getPlanByIdTest() {
				mockServer.expect(requestTo(containsString("public/dmps")))
					        .andExpect(method(HttpMethod.GET))
					        .andRespond(withSuccess("{\"payload\": { \"id\": \"78f64f2d-8686-4dad-8d97-cb7763dbba27\", \"label\": \"Dmp For Project : 00332/EI\", \"grant\": { \"id\": \"foo\", \"label\": \"00332/EI\" }, \"createdAt\": 1560252575000, \"modifiedAt\": 1560254599000 } }", MediaType.APPLICATION_JSON));
				try {
					ArgosDMP plan = argosClientImpl.getPlanById("78f64f2d-8686-4dad-8d97-cb7763dbba27");
					assertEquals(plan.label, "Dmp For Project : 00332/EI");
					assertEquals(plan.grant.label, "00332/EI");
				} catch (MalformedURLException | URISyntaxException e) {
					fail("argosClient.getPlanById threw an exception.");
				}
		}
}

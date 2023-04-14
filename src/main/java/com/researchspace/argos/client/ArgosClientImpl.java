package com.researchspace.argos.client;

import com.researchspace.argos.model.ArgosDMP;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.ResponseItem;
import com.researchspace.argos.model.TableRequest;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
@Slf4j
public class ArgosClientImpl implements ArgosClient {

	/*
	 * Thes apiUrlBase is the full domain and path to the public portion of the
	 * API. For example, "https://devel.opendmp.eu/srv/api/public"
	 */
	private URL apiUrlBase;

	/*
	 * Whilst private, the restTemplate can be set when unit testing. It should
	 * not be set at any other time.
	 */
	private RestTemplate restTemplate;

	public ArgosClientImpl(URL apiUrlBase) {
			this.apiUrlBase = apiUrlBase;
			this.restTemplate = new RestTemplate();
	}

	public DataTableData<ArgosDMPListing> listPlans(TableRequest request) throws MalformedURLException, URISyntaxException {
		return restTemplate.exchange(
			// this method only currently supports listing fieldsGroup, but could
			// be extended to support the autocomplete fieldsGroup
			this.apiUrlBase + "/dmps?fieldsGroup=listing",
			HttpMethod.POST,
			new HttpEntity<>(request, getHttpHeaders()),
			new ParameterizedTypeReference<ResponseItem<DataTableData<ArgosDMPListing>>>() {}
		).getBody().getPayload();
	}

	public ArgosDMP getPlanById(String id) throws MalformedURLException, URISyntaxException {
		return restTemplate.exchange(
			this.apiUrlBase + "/dmps/" + id,
			HttpMethod.GET,
			new HttpEntity<>(getHttpHeaders()),
			new ParameterizedTypeReference<ResponseItem<ArgosDMP>>() {}
		).getBody().getPayload();
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return headers;
	}

}

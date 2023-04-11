package com.researchspace.argos.client;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.ArgosDMP;
import com.researchspace.argos.model.TableRequest;
import com.researchspace.argos.model.ResponseItem;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import java.net.URL;
import org.springframework.http.HttpHeaders;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Getter
@Setter
@Slf4j
public class ArgosClientImpl implements ArgosClient {

  private URL apiUrlBase;
  private RestTemplate restTemplate;

  public ArgosClientImpl(URL apiUrlBase) {
      this.apiUrlBase = apiUrlBase;
      this.restTemplate = new RestTemplate();
  }

  public DataTableData<ArgosDMPListing> listPlans(TableRequest request) throws MalformedURLException, URISyntaxException {
    return restTemplate.exchange(
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

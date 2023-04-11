package com.researchspace.argos.client;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.ArgosDMP;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import java.net.URL;

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

  public DataTableData<ArgosDMPListing> listPlans() {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public ArgosDMP getPlanById(String id) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}

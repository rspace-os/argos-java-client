package com.researchspace.argos.client;

import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.ArgosDMP;
import com.researchspace.argos.model.TableRequest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/*
 * This interface declares the operations that this library supports with
 * regard to the Argos API.
 */
public interface ArgosClient {
  DataTableData<ArgosDMPListing> listPlans(TableRequest request) throws MalformedURLException, URISyntaxException;
  ArgosDMP getPlanById(String id);
}

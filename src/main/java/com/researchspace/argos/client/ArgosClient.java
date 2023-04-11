package com.researchspace.argos.client;

import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.ArgosDMP;

/*
 * This interface declares the operations that this library supports with
 * regard to the Argos API.
 */
public interface ArgosClient {
  DataTableData<ArgosDMPListing> listPlans();
  ArgosDMP getPlanById(String id);
}

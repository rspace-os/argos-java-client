package com.researchspace.argos.client;

import com.researchspace.argos.model.ArgosDMP;
import com.researchspace.argos.model.ArgosDMPListing;
import com.researchspace.argos.model.DataTableData;
import com.researchspace.argos.model.TableRequest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/*
 * This interface declares the operations that this library supports with
 * regard to the Argos API.
 */
public interface ArgosClient {

	/*
	 * Fetches a listing of all of the DMPs that match the criteria specified in
	 * the TableRequest. This is the mechanism by which user interfaces may fetch
	 * a listing of the availiable DMPs that a user may browse.
	 */
	DataTableData<ArgosDMPListing> listPlans(
		TableRequest request
	) throws MalformedURLException, URISyntaxException;

	/*
	 * Fetches the full details of a DMP, specified by the ID that is internal to
	 * Argos. Note that this ID is not a DOI or any other globally uniqe
	 * identifier.
	 */
	ArgosDMP getPlanById(
		String id
	) throws MalformedURLException, URISyntaxException;
}

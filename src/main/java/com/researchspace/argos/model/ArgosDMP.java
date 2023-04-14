package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This class models Argos's definition of a DMP, that may be distinct from how
 * other organisation define a DMP. This class only captures a subset of the
 * data; that which has been determined to be useful for some application of
 * this library. This class can and should be expanded where capturing
 * additional data is required.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArgosDMP {

	public String id;
	public String label;
	public ApiDMPGrant grant;
	public List<ApiDMPDoi> dois;

	@Data
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ApiDMPGrant {
		public String id;
		public String label;
	}

	@Data
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ApiDMPDoi {
		public String doi;
		public String repositoryId;
	}

	public Optional<String> getDoi() {
		if (dois.isEmpty()) return Optional.empty();
		return Optional.of(dois.get(0).doi);
	}

}

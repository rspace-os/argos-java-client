package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Optional;

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

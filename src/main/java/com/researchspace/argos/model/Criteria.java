package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * Requesting a listing of DMPs from Argos, comes with the need to pass some
 * search criteria by which to filter that listing. This class models some, but
 * not all, of the available search criteria.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Criteria {
	private String like;
	private List<String> grantsLike;
	private List<String> fundersLike;
	private List<String> collaboratorsLike;
}

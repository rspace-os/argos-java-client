package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * When performing a query, the API will return the results wrapped in an
 * object that records various pieces of metadata such as status code and
 * possible error messages. This class models this object doing the wrapping
 * but ignores the metadata. Should the metadata be useful, then this class
 * should be expanded to include those properties.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseItem<T> {
	private T payload;
}

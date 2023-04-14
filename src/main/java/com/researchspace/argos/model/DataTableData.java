package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Requests for multiple records come wrapped in this type.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTableData<T> {

	// The actual data requested.
	private List<T> data;

	// The total nuber of records that match the search criteria.
	// If this number if larger that the passed page size, then the size of the
	// data property above will be equal to the page size, otherwise it will be
	// equal to this totalCount property.
	private Integer totalCount;

	public List<T> getData() {
		return this.data;
	}
}

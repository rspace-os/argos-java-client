package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

/*
 * Requests for listings of DMPs, require various pieces of data that specify
 * which DMPs should be returned. This includes filters that constrain the set
 * of DMPs based on their various properties and other values that provide
 * support for pagination.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableRequest {
	public Integer length;
	public Integer offset;
	public Criteria criteria;

	public TableRequest(Integer pageSize, Integer page, Criteria criteria) {
		this.length = pageSize;
		this.offset = pageSize * page;
		this.criteria = criteria;
	}

}

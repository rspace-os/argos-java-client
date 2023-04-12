package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

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

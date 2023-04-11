package com.researchspace.argos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;
import lombok.AllArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Criteria {
  private String like;
  private List<String> grantsLike;
  private List<String> fundersLike;
  private List<String> collaboratorsLike;
}

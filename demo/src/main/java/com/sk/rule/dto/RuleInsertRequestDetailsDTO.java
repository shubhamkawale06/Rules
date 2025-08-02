package com.sk.rule.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleInsertRequestDetailsDTO {
	private String pol;
	private String pod;
	private String plor;
	private String plod;
	private RuleTypeDto ruleTypeOne;
	private RuleTypeDto ruleTypeTwo;
	private RuleTypeDto ruleTypeThree;
	private List<String> origCountryIn;
	private List<String> origCountryNotIn;
	private List<String> desCountryIn;
	private List<String> desCountryNotIn;
	private List<String> origStationIn;
	private List<String> origStationNotIn;
	private List<String> desStationIn;
	private List<String> desStatioNotIn;
}

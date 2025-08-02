package com.sk.rule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleRequestAttrDTO {
	private String ruleGroup;
	private RuleInsertRequestMasterDTO ruleMaster;
	private RuleInsertRequestDetailsDTO ruleDetails;
	private String actionTaken;
	private String actionTakenBy;
	private String effStartDateTime;
	private String effEndDateTime;
}

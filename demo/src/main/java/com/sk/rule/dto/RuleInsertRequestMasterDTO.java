package com.sk.rule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleInsertRequestMasterDTO {

	private Integer ruleId;
	private String tradelane;
	private String ddhCustomerCode;
	private String ddhCustomerLevel;
	private String customerGroup;

}

package com.sk.rule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_tradelane_rule_audit")
public class TradelaneRuleAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TradelaneRuleAuditID")
	private Integer tradelaneRuleAuditID;

	@Column(name = "TradelaneRuleID")
	private Integer tradelaneRuleID;

	@Column(name = "EffectiveStartDate")
	private String effectiveStartDate;

	@Column(name = "EffectiveEndDate")
	private String effectiveEndDate;

	@Column(name = "ActionTaken")
	private String actionTaken;

	@Column(name = "ActionTakenBy")
	private String actionTakenBy;

	@Column(name = "ActionTimeStamp")
	private String actionTimeStamp;

	@Column(name = "Version")
	private Integer version;

	@Column(name = "RuleStatus")
	private Integer ruleStatus;
}

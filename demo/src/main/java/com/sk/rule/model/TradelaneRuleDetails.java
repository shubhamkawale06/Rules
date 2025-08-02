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
@Table(name = "tbl_tradelane_rule_details")
public class TradelaneRuleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TradelaneRuleEntryId")
	private Integer tradelaneRuleEntryId;

	@Column(name = "TradelaneRuleID")
	private Integer tradelaneRuleID;

	@Column(name = "Version")
	private Integer version;

	@Column(name = "RuleTypeOne")
	private String ruleTypeOne;

	@Column(name = "OperatorOne")
	private String operatorOne;

	@Column(name = "ValueOne")
	private String valueOne;

	@Column(name = "RuleTypeTwo")
	private String ruleTypeTwo;

	@Column(name = "OperatorTwo")
	private String operatorTwo;

	@Column(name = "ValueTwo")
	private String valueTwo;

	@Column(name = "RuleTypeThree")
	private String ruleTypeThree;

	@Column(name = "OperatorThree")
	private String operatorThree;

	@Column(name = "ValueThree")
	private String valueThree;

	@Column(name = "POL")
	private String pol;

	@Column(name = "POD")
	private String pod;

	@Column(name = "PLOR")
	private String plor;

	@Column(name = "PLOD")
	private String plod;

	@Column(name = "OriginCountryIn")
	private String originCountryIn;

	@Column(name = "OriginCountryNotIn")
	private String originCountryNotIn;

	@Column(name = "DestinationCountryIn")
	private String destinationCountryIn;

	@Column(name = "DestinationCountryNotIn")
	private String destinationCountryNotIn;

	@Column(name = "OriginStationIn")
	private String originStationIn;

	@Column(name = "OriginStationNotIn")
	private String originStationNotIn;

	@Column(name = "DestinationStationIn")
	private String destinationStationIn;

	@Column(name = "DestinationStationNotIn")
	private String destinationStationNotIn;

	@Column(name = "Mandate")
	private String mandate;

	@Column(name = "Priority")
	private String priority;

}

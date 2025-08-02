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
@Table(name = "tbl_tradelane_rule_master")
public class TradelaneMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tradelaneRuleId")
	private Integer tradelaneRuleId;

	@Column(name = "tradelane")
	private String tradelane;

	@Column(name = "customerCode")
	private String customerCode;

	@Column(name = "customerLevel")
	private String customerLevel;

	@Column(name = "customerGroup")
	private String customerGroup;

}

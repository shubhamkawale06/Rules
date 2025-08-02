package com.sk.rule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sk.rule.dto.RuleRequestAttrDTO;
import com.sk.rule.dto.RuleRequestBodyDTO;
import com.sk.rule.model.TradelaneMaster;
import com.sk.rule.model.TradelaneRuleAudit;
import com.sk.rule.model.TradelaneRuleDetails;
import com.sk.rule.repository.TradelaneAuditRepository;
import com.sk.rule.repository.TradelaneDetailsRepository;
import com.sk.rule.repository.TradelaneMasterRepository;

@Service
public class RuleService {

	private TradelaneMasterRepository tradelaneMasterRepository;
	private TradelaneDetailsRepository tradelaneDetailsRepository;
	private TradelaneAuditRepository tradelaneAuditRepository;

	public RuleService(TradelaneMasterRepository tradelaneMasterRepository,
			TradelaneDetailsRepository tradelaneDetailsRepository, TradelaneAuditRepository tradelaneAuditRepository) {
		this.tradelaneMasterRepository = tradelaneMasterRepository;
		this.tradelaneDetailsRepository = tradelaneDetailsRepository;
		this.tradelaneAuditRepository = tradelaneAuditRepository;
	}

	public void insertRule(RuleRequestBodyDTO ruleRequest, Integer userId) {
		List<RuleRequestAttrDTO> ruleRequestList = ruleRequest.getRuleReqBodyList();
		ruleRequestList.forEach(entry -> {
			TradelaneMaster tradelaneMaster = generateEntityForMaster(entry);
			tradelaneMasterRepository.save(tradelaneMaster);
			TradelaneRuleDetails tradelaneRuleDetails = generateEntityForDetails(entry,
					tradelaneMaster.getTradelaneRuleId());
			tradelaneDetailsRepository.save(tradelaneRuleDetails);
			TradelaneRuleAudit tradelaneRuleAudit = generateEntityForAudit(entry, tradelaneMaster.getTradelaneRuleId());
			tradelaneAuditRepository.save(tradelaneRuleAudit);

		});
	}

	private TradelaneMaster generateEntityForMaster(RuleRequestAttrDTO entry) {
		return TradelaneMaster.builder().tradelane(entry.getRuleMaster().getTradelane())
				.customerCode(entry.getRuleMaster().getDdhCustomerCode())
				.customerLevel(entry.getRuleMaster().getDdhCustomerLevel())
				.customerGroup(entry.getRuleMaster().getCustomerGroup()).build();
	}

	private TradelaneRuleDetails generateEntityForDetails(RuleRequestAttrDTO entry, Integer ruleId) {
		return TradelaneRuleDetails.builder().tradelaneRuleID(ruleId).version(1)
				.ruleTypeOne(entry.getRuleDetails().getRuleTypeOne().getRuleType())
				.operatorOne(entry.getRuleDetails().getRuleTypeTwo().getRuleType())
				.valueOne(entry.getRuleDetails().getRuleTypeThree().getValue())
				.ruleTypeTwo(entry.getRuleDetails().getRuleTypeTwo().getRuleType())
				.operatorTwo(entry.getRuleDetails().getRuleTypeTwo().getOperator())
				.valueTwo(entry.getRuleDetails().getRuleTypeTwo().getValue())
				.ruleTypeThree(entry.getRuleDetails().getRuleTypeThree().getRuleType())
				.operatorThree(entry.getRuleDetails().getRuleTypeThree().getOperator())
				.valueThree(entry.getRuleDetails().getRuleTypeThree().getValue()).build();
	}

	private TradelaneRuleAudit generateEntityForAudit(RuleRequestAttrDTO entry, Integer ruleId) {

		return TradelaneRuleAudit.builder().tradelaneRuleID(ruleId).effectiveStartDate(entry.getEffStartDateTime())
				.effectiveEndDate(entry.getEffStartDateTime()).actionTaken(entry.getActionTaken())
				.actionTakenBy(entry.getActionTakenBy()).actionTimeStamp("").version(1).ruleStatus(0).build();
	}
}

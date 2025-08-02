package com.sk.rule.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.rule.dto.ResponseDTO;
import com.sk.rule.dto.RuleRequestAttrDTO;
import com.sk.rule.dto.RuleRequestBodyDTO;
import com.sk.rule.service.RuleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/sk/ruleconfiguration")
@Slf4j
public class RuleController {

	RuleService ruleService;

	public RuleController(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	@PostMapping("rule/save")
	public ResponseEntity<ResponseDTO> saveRule(@RequestBody RuleRequestBodyDTO ruleRequestBody,
			@RequestParam("UserId") Integer userId) {

		boolean isDuplicateRequest = isDuplicateRequestMethod(ruleRequestBody);
		if(isDuplicateRequest) {
			ruleService.insertRule(ruleRequestBody, userId);
		}else {
			log.info("Duplicate found");
		}
		
		return ResponseEntity.ok(ResponseDTO.builder().returnValue(1).errorMessage("Success").build());
	}

	private boolean isDuplicateRequestMethod(RuleRequestBodyDTO ruleRequestBody) {
		Set<RuleRequestAttrDTO> uniqueSet = new HashSet<>();
		List<RuleRequestAttrDTO> duplicates = new ArrayList<>();

		for (RuleRequestAttrDTO dto : ruleRequestBody.getRuleReqBodyList()) {
			if (!uniqueSet.add(dto)) {
				duplicates.add(dto); // already exists, so it's a duplicate
				return false;
			}
		}
		return true;
	}

}

package com.sk.rule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.rule.dto.ResponseDTO;
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

		ruleService.insertRule(ruleRequestBody, userId);
		return ResponseEntity.ok(ResponseDTO.builder().returnValue(1).errorMessage("Success").build());
	}

}

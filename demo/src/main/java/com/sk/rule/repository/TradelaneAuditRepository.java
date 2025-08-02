package com.sk.rule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.rule.model.TradelaneRuleAudit;

public interface TradelaneAuditRepository extends JpaRepository<TradelaneRuleAudit, Integer> {

}

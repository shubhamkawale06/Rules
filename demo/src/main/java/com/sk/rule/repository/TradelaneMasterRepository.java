package com.sk.rule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.rule.model.TradelaneMaster;

@Repository
public interface TradelaneMasterRepository extends JpaRepository<TradelaneMaster, Integer>{

}

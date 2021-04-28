package com.yanzhenyidai.drools.repository;

import com.yanzhenyidai.drools.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:36
 */
public interface RuleRepository extends JpaRepository<Rule, Long> {

    Rule findByRuleKey(String ruleKey);
}

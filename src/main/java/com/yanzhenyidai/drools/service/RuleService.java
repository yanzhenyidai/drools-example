package com.yanzhenyidai.drools.service;

import com.yanzhenyidai.drools.domain.Rule;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:39
 */
public interface RuleService {

    public Rule generatorRule(String ruleKey);

    public List<Rule> findAll();

    public Rule findByRuleKey(String ruleKey);

    public Rule findById(Long id);
}

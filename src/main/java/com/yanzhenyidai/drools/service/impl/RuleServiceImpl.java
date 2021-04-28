package com.yanzhenyidai.drools.service.impl;

import com.yanzhenyidai.drools.domain.Element;
import com.yanzhenyidai.drools.domain.Rule;
import com.yanzhenyidai.drools.dto.RuleRequest;
import com.yanzhenyidai.drools.repository.ElementRepository;
import com.yanzhenyidai.drools.repository.RuleRepository;
import com.yanzhenyidai.drools.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:40
 */
@Service
public class RuleServiceImpl extends AbstractRuleContent implements RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Rule generatorRule(String ruleKey) {
        Element e = new Element();
        e.setRuleKey(ruleKey);

        List<Element> elementList = elementRepository.findAll(Example.of(e));

        RuleRequest elementRequest = new RuleRequest();
        elementRequest.setRuleKey(ruleKey);
        elementRequest.setElementList(elementList);

        String content = this.content(elementRequest);

        Rule rule1 = ruleRepository.findByRuleKey(ruleKey);
        if (rule1 != null) {
            rule1.setContent(content);
            return ruleRepository.saveAndFlush(rule1);
        }

        Rule rule = new Rule();
        rule.setRuleKey(elementRequest.getRuleKey());
        rule.setContent(content);

        return ruleRepository.save(rule);
    }

    @Override
    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule findByRuleKey(String ruleKey) {
        return ruleRepository.findByRuleKey(ruleKey);
    }

    @Override
    public Rule findById(Long id) {
        return ruleRepository.findById(id).get();
    }
}

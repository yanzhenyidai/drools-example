package com.yanzhenyidai.drools.controller;

import com.yanzhenyidai.drools.config.RuleConfiguration;
import com.yanzhenyidai.drools.domain.Rule;
import com.yanzhenyidai.drools.dto.TriggerRequest;
import com.yanzhenyidai.drools.dto.TriggerResponse;
import com.yanzhenyidai.drools.dto.drools.Properties;
import com.yanzhenyidai.drools.dto.drools.PropertiesCheckResult;
import com.yanzhenyidai.drools.service.RuleService;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 16:05
 */
@RestController
@RequestMapping(value = "/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private RuleConfiguration ruleConfiguration;

    @RequestMapping(value = "/generatorRule")
    public Rule generatorRule(String ruleKey) {
        return ruleService.generatorRule(ruleKey);
    }

    @RequestMapping(value = "/findAll")
    public List<Rule> findAll() {
        return ruleService.findAll();
    }

    @RequestMapping(value = "/loadRule")
    public void loadRule() {
        ruleConfiguration.loadRuleList();
    }

    @RequestMapping(value = "triggerRule")
    public TriggerResponse triggerRule(@RequestBody List<TriggerRequest> request) {

        TriggerResponse response = new TriggerResponse();

        request.forEach((TriggerRequest r) -> {

            Properties address = new Properties();
            address.setPostcode(r.getpVal());
            KieSession kieSession = RuleConfiguration.kieContainer.newKieSession();

            PropertiesCheckResult result = new PropertiesCheckResult();
            kieSession.insert(address);
            kieSession.insert(result);

            int ruleFiredCount = kieSession.fireAllRules(new RuleNameEqualsAgendaFilter(r.getRuleKey() + "-" + r.getpName()));

            kieSession.destroy();
            System.out.println("触发了" + ruleFiredCount + "条规则");

            if (!result.isPostCodeResult()) {
                response.getErrorMsgList().add("ruleKey-" + r.getRuleKey() + "-" + r.getpName() + "规则校验未通过");
            }

            if (ruleFiredCount == 0) {
                response.setMessage("未通过");
            }
        });

        return response;
    }
}

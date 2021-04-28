package com.yanzhenyidai.drools.config;

import com.yanzhenyidai.drools.domain.Rule;
import com.yanzhenyidai.drools.service.RuleService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 16:10
 */
@Service
public class RuleConfiguration {

    public static KieContainer kieContainer;

    @Autowired
    private RuleService ruleService;

    public void loadRuleList() {
        List<Rule> ruleList = new ArrayList<>();

        List<Rule> rules = ruleService.findAll();
        for (Rule r : rules) {
            Rule rule = ruleService.generatorRule(r.getRuleKey());
            ruleList.add(rule);
        }

        KieContainer kieContainer = loadContainerFromString(ruleList);
        this.kieContainer = kieContainer;
    }

    private KieContainer loadContainerFromString(List<Rule> rules) {
        long startTime = System.currentTimeMillis();
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        for (Rule rule : rules) {
            String drl = rule.getContent();
            kfs.write("src/main/resources/" + drl.hashCode() + ".drl", drl);
        }

        KieBuilder kb = ks.newKieBuilder(kfs);

        kb.buildAll();
        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time to build rules : " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());

        endTime = System.currentTimeMillis();
        System.out.println("Time to load container: " + (endTime - startTime) + " ms");

        return kContainer;
    }
}

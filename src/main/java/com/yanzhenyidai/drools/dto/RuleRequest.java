package com.yanzhenyidai.drools.dto;

import com.yanzhenyidai.drools.domain.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:40
 */
public class RuleRequest implements Serializable {

    private String ruleKey;

    private List<Element> elementList = new ArrayList<>();

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}

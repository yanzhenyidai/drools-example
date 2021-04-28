package com.yanzhenyidai.drools.dto;

import java.io.Serializable;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-26 10:33
 */
public class TriggerRequest implements Serializable {

    private String ruleKey;

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    private String pName;

    private String pVal;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpVal() {
        return pVal;
    }

    public void setpVal(String pVal) {
        this.pVal = pVal;
    }

}

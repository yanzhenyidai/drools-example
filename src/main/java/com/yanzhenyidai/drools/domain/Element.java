package com.yanzhenyidai.drools.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-23 15:00
 */
@Entity
public class Element implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String ruleKey;

    @Column
    private String pName;

    @Column
    private String pReg;

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpReg() {
        return pReg;
    }

    public void setpReg(String pReg) {
        this.pReg = pReg;
    }
}

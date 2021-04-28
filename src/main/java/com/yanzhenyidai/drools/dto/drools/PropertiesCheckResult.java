package com.yanzhenyidai.drools.dto.drools;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:46
 */
public class PropertiesCheckResult {

    private boolean postCodeResult = false; // true:通过校验；false：未通过校验

    public boolean isPostCodeResult() {
        return postCodeResult;
    }

    public void setPostCodeResult(boolean postCodeResult) {
        this.postCodeResult = postCodeResult;
    }
}

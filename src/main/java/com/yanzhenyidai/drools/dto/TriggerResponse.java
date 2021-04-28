package com.yanzhenyidai.drools.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-26 13:27
 */
public class TriggerResponse implements Serializable {

    private boolean success;

    private String message = "通过";

    private List<String> errorMsgList = new ArrayList<>();

    public boolean isSuccess() {
        return getErrorMsgList().isEmpty();
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrorMsgList() {
        return errorMsgList;
    }

    public void setErrorMsgList(List<String> errorMsgList) {
        this.errorMsgList = errorMsgList;
    }
}

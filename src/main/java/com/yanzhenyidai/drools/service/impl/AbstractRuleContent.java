package com.yanzhenyidai.drools.service.impl;

import com.yanzhenyidai.drools.domain.Element;
import com.yanzhenyidai.drools.dto.RuleRequest;

/**
 * @author frank
 * @version 1.0
 * @date 2021-04-28 15:40
 */
public abstract class AbstractRuleContent {

    public String content(RuleRequest request) {

        StringBuffer sb = new StringBuffer();

        sb.append("package drools.example\n" +
                "\n" +
                "import com.yanzhenyidai.drools.dto.drools.Properties;\n" +
                "import com.yanzhenyidai.drools.dto.drools.PropertiesCheckResult;\n");

        request.getElementList().forEach((Element e) -> {
            sb.append("\nrule \"" + request.getRuleKey() + "-" + e.getpName() + "\"\n");
            sb.append("\twhen\n");
            sb.append("\t\taddress : Properties(postcode != null, postcode matches \"" + e.getpReg() + "\")\n");
            sb.append("\t\tcheckResult : PropertiesCheckResult();\n");
            sb.append("\tthen\n");
            sb.append("\t\tcheckResult.setPostCodeResult(true);\n");
            sb.append("\t\tSystem.out.println(\"" + e.getpName() + "：校验通过!\");\n");

            sb.append("end");
        });

        return sb.toString();
    }
}

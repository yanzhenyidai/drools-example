
# drools-example

> Drools的简单示例

## 运行流程

1. 使用SpringBoot构建，直接在DroolsApplication运行
2. 浏览器访问 `http://localhost:8082`

## 操作流程

![drools-2021.png](https://i.loli.net/2021/04/28/s8xfQvgtTUw6u59.png)

1. 添加规则
    - ruleKey： 规则唯一标识
    - pName： 规则字段信息
    - pReg： 规则所对应的正则
2. 生成规则
    - 生成： 输入ruleKey信息，生成Drools的drl文件，并存到数据库rule表中
3. 加载所有
    - 加载： 一次性加载所有规则信息，存放到Drools的KieContainer容器中
4. 触发
    - 触发： 根据rule规则在KieContainer中找到对应的ruleKey-pName信息
    
## 规则

1. 以单个ruleKey为文件单位，生成drl文件
2. rule信息以 `ruleKey-pName` 为命名标准

```drools
package drools.example

import com.yanzhenyidai.drools.dto.drools.Properties;
import com.yanzhenyidai.drools.dto.drools.PropertiesCheckResult;

rule "test-name"
	when
		address : Properties(postcode != null, postcode matches "([0-9]{6})")
		checkResult : PropertiesCheckResult();
	then
		checkResult.setPostCodeResult(true);
		System.out.println("name：校验通过!");
end
rule "test-name1"
	when
		address : Properties(postcode != null, postcode matches "([0-9]{5})")
		checkResult : PropertiesCheckResult();
	then
		checkResult.setPostCodeResult(true);
		System.out.println("name1：校验通过!");
end
```

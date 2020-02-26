package com.orange.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 2 * @Author: hanx1a0
 * 3 * @Date: 2020/2/25 16:03
 * 4
 */
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();
        if(env.getProperty("os.name").contains("linux")){
            return true;
        }
        return false;
    }
}

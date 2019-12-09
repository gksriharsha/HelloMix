package com.estat.HelloMix.Configuration;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;

import org.springframework.core.type.AnnotatedTypeMetadata;

public class FetchTMDBCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String APIName = conditionContext.getEnvironment().getProperty("FETCHER");
        return APIName.equals("TMDB");
    }
}

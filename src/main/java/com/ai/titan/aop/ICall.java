package com.ai.titan.aop;

import org.springframework.stereotype.Component;

@Component
public interface ICall {

    public Integer add(Integer num1,Integer num2);

    public Integer div(Integer num1,Integer num2);
}

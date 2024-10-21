package com.ai.titan.aop;

import org.springframework.stereotype.Service;

@Service
public class Call implements  ICall{
    @Override
    public Integer add(Integer num1, Integer num2) {

        return  num1 + num2;
    }

    @Override
    public Integer div(Integer num1, Integer num2) {
        return  num1 / num2;
    }
}

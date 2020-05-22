package com.mycompany.mystore.service.function;

import org.springframework.stereotype.Component;

import java.util.function.UnaryOperator;

@Component
public class FilterCleaner implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return s.replaceAll("[-+.^:,]", "");
    }

}

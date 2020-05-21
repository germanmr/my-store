package com.mycompany.mystore.service.function;

import java.util.function.UnaryOperator;

public class FilterCleaner implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return s.replaceAll("[-+.^:,]", "");
    }

}

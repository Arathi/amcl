package com.undsf.amcl.configs;

import com.undsf.amcl.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class Argument {
    public Argument() {}

    public Argument(String value) {
        this.value = new ArrayList<>();
        this.value.add(value);
    }

    public List<Object> rules;
    public List<String> value;

    @Override
    public String toString() {
        if (rules != null && value !=null) {
            return rules.size() + "条规则，" + value.size() + "个值";
        }
        else if (rules == null && value != null && value.size() == 1) {
            return value.get(0);
        }
        return "特殊的参数：" + JsonUtil.writeValue(this);
    }
}

package com.forbitbd.bcspreperation.model;

import java.io.Serializable;

public class PreviousQuestionType implements Serializable {

    private String name;
    private String bangla_name;

    public PreviousQuestionType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBangla_name() {
        return bangla_name;
    }

    public void setBangla_name(String bangla_name) {
        this.bangla_name = bangla_name;
    }
}

package com.xzy.demo.dal.common;


import java.io.Serializable;
import java.util.List;

/**
 * Created by RuzzZZ on 2017/3/28.
 */
public class Criterion implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String condition;
    protected Object value;
    protected Object secondValue;
    protected boolean noValue;
    protected boolean singleValue;
    protected boolean betweenValue;
    protected boolean listValue;
    protected String typeHandler;

    public String getCondition() {
        return this.condition;
    }

    public Object getValue() {
        return this.value;
    }

    public Object getSecondValue() {
        return this.secondValue;
    }

    public boolean isNoValue() {
        return this.noValue;
    }

    public boolean isSingleValue() {
        return this.singleValue;
    }

    public boolean isBetweenValue() {
        return this.betweenValue;
    }

    public boolean isListValue() {
        return this.listValue;
    }

    public String getTypeHandler() {
        return this.typeHandler;
    }

    public Criterion(String condition) {
        this.condition = condition;
        this.typeHandler = null;
        this.noValue = true;
    }

    public Criterion(String condition, Object value, String typeHandler) {
        this.condition = condition;
        this.value = value;
        this.typeHandler = typeHandler;
        if (value instanceof List) {
            this.listValue = true;
        } else {
            this.singleValue = true;
        }

    }

    public Criterion(String condition, Object value) {
        this(condition, value, (String) null);
    }

    public Criterion(String condition, Object value, Object secondValue, String typeHandler) {
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.typeHandler = typeHandler;
        this.betweenValue = true;
    }

    public Criterion(String condition, Object value, Object secondValue) {
        this(condition, value, secondValue, (String) null);
    }

    public String toString() {
        return this.isNoValue() ? this.condition : (this.isSingleValue() ? this.condition + " " + this.getValue() : (this.isBetweenValue() ? this.condition + " " + this.value + " and " + this.secondValue : (this.isListValue() ? this.condition + " in " + this.value : "invalid status")));
    }
}

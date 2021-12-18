package com.djr.demo.mybatis.test;

import java.util.Objects;

public class Test {

    public static void main(String[] args)
    {

    }

    //具体算法


    private String attribute1;
    private int attribute2;

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public int getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(int attribute2) {
        this.attribute2 = attribute2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return attribute2 == test.attribute2 && Objects.equals(attribute1, test.attribute1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute1, attribute2);
    }
}

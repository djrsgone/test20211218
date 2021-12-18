package com.djr.demo.mybatis.learning;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public interface NewIF {

    public static void main(String[] args){
        NewIF.increase();
        NewIF ins = new NewIF() {
        };
        ins.g();
    }

    public static void increase() {
        AtomicInteger idGenerator = new AtomicInteger();
        idGenerator.incrementAndGet();
        System.out.println("id =" + idGenerator.get());
    }

    public default void g(){
        System.out.println("[interface]g is created");
    }
}

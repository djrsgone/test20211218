package com.djr.demo;

public class TestUtils {

    public static String buildString(int length){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length; i++){
            char c = (char) ('0' + i % 10);
            buffer.append(c);
        }
        return buffer.toString();
    }

}

package com.djr.demo.mybatis.learning.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    private String name;
    private int age;
    private int sex;
}

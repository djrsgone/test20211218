package com.example.firstappdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stu {

    @Id
    private String id;

    private String nane;

    private int sex;
}

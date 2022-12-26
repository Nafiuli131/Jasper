package com.example.Jasper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String doj;
}

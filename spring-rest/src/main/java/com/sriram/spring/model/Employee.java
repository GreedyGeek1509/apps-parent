package com.sriram.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@XmlRootElement(name = "Employee")
public class Employee {
    private int id;
    private String name;
    private String email;
}

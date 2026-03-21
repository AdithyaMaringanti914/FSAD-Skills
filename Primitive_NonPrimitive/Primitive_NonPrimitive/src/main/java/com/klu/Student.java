package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("101")
	private int id;
	@Value("9110531198")
	private long phone;
	@Value("86.8")
	private float marks;
	@Autowired
    private Course c;
	
	public void display() {
        System.out.println("---- Student Details ----");
        System.out.println("ID          : " + id);
        System.out.println("Phone       : " + phone);
        System.out.println("Marks       : " + marks);
        System.out.println("Course      : " + c.getCourseName());
       
	}
	

}

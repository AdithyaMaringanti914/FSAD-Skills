package com.klu;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("demo1")
	public int fun1()
	{
		return 10;
		
		  
	}
	@GetMapping("demo2")
	public String fun2()
	{
		return "welcome to the university";
	}
	
	@GetMapping("/demo3/{a}/{b}")
	public int fun3(@PathVariable("a") int a,@PathVariable("b") int b)
	{
		return a+b;
		
	}
	@GetMapping("offline")
	public String fun4()
	{
		return "error 404";
	}
				
}

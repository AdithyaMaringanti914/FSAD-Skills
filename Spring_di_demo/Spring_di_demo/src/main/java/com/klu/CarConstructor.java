package com.klu;

import org.springframework.stereotype.Component;

@Component
public class CarConstructor {
	
	private Engine eng;
	public CarConstructor(Engine engine) {
		this.eng=engine;
	}

	public void drive()
	{
		System.out.println("Constructor Injection: "+eng.type());
	}

}

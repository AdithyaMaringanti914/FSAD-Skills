package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo pr;
	

	
}

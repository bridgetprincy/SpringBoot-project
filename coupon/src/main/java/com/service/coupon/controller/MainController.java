package com.service.coupon.controller;

import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.coupon.service.GeneratorString;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	
	@Autowired
	private GeneratorString generator;
	
	@GetMapping("/hash")
	public String hashvalue() throws NoSuchAlgorithmException {
		
		return generator.idGenerate();
		
	}

}

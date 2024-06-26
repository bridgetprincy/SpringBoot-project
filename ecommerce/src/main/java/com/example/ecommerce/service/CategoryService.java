package com.example.ecommerce.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;



@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
	public void addcategory(Category category) {
		
		categoryRepo.save(category);
	}
			
	public void removeCategoryById(int id) {
		categoryRepo.deleteById(id);
		
	}
	
	public Optional<Category> getCategoryById(int id){
		
		return categoryRepo.findById(id);
	}

}

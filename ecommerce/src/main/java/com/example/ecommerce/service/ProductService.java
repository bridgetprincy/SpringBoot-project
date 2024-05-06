
  package com.example.ecommerce.service;
  
  import java.util.List; 
  import java.util.Optional; 
  import
  org.springframework.beans.factory.annotation.Autowired;
  import
  org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;


  @Service 
  
  public class ProductService {
  
  @Autowired 
  ProductRepository productRepo;
  
  public List<Product> getAllProduct(){ 
	  return productRepo.findAll(); 
  }
  
  public void addProduct(Product product) {
  
  productRepo.save(product);
  
  }
  
  public void removeProductById(long id) {
  
  productRepo.deleteById(id); 
  }
  
  public Optional<Product> getProductById(long id){
  
  return productRepo.findById(id); 
  }
  
  public List<Product> getAllProductsByCategoryId(int id){
	  
 return productRepo.findAllByCategory_Id(id); }
  
  
  }
 
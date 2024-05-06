package com.example.ecommerce.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.ecommerce.dto.ProductDTO;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;


@Controller
@CrossOrigin(origins = "*")

public class AdminController {
	
	/*
	 * @Value("${file.path}") private String uploadDir;
	 */
	
	 //= System.getProperty("user.dir")
	
	public static String uploadDir = System.getProperty("user.dir") + "/static/img";
	
	 @Autowired ProductService productServe;
	 
	
	@Autowired
	CategoryService categoryServe;
	
	 
	 
	@GetMapping("/admin")	
	public String adminHome() {
		
		return "adminHome";
	}
	
	@GetMapping("/admin/login")
    public String viewAdminLoginPage() {
        return "adminLogin";
    }
	
	  @GetMapping("admin/categories") 
	  
	  public String getCat(Model model) {
	  
	  model.addAttribute("categories", categoryServe.getAllCategory());
	  
	  return "categories"; 
	  }
	  
	  @GetMapping("/admin/categories/add") 
	  
	  public String getCatAdd(Model model) {
	  model.addAttribute("category", new Category()); 
	  return "categoriesAdd";
	  }
	  
	  @PostMapping("/admin/categories/add") 
	  public String postCatAdd(@ModelAttribute("category") Category category) {
	  categoryServe.addcategory(category); 
	  return "redirect:/admin/categories"; 
	  }
	  
	  @GetMapping("/admin/categories/delete/{id}") 
	  public String deleteCat(@PathVariable int id) {
	  
	  categoryServe.removeCategoryById(id); 
	  return "redirect:/admin/categories";
	  
	  }
	  
	  @GetMapping("/admin/categories/update/{id}")
	  
	  public String updateCart(@PathVariable int id, Model model) {
	  
	  Optional<Category> category=categoryServe.getCategoryById(id);
	  if(category.isPresent()) {
		  
		 
	  
	  model.addAttribute("category", category.get()); return "categoriesAdd"; }else
	  
	  return "404";
	  
	  }
	
		
		  @GetMapping("/admin/products") public String products(Model model) {
		  model.addAttribute("products", productServe.getAllProduct()); return
		  "products";
		  
		  }
		  
		  @GetMapping("/admin/products/add") public String productAddGet(Model model) {
		  model.addAttribute("productDTO", new ProductDTO());
		  model.addAttribute("categories", categoryServe.getAllCategory());
		  
		  return "productsAdd"; }
		  
		  @PostMapping("/admin/products/add")
		  
		  public String productAddPost(@ModelAttribute("productDTO")ProductDTO
		  productDTO,
		  
		  @RequestParam("img")MultipartFile file,
		  
		  @RequestParam("imgName")String imgName) throws IOException {
		  
		  Product product =new Product();
		  product.setId(productDTO.getId());
		  product.setName(productDTO.getName());
		  product.setCategory(categoryServe.getCategoryById(productDTO.getCategoryId()).get()); product.setPrice(productDTO.getPrice());
		  product.setWeight(productDTO.getWeight());
		  product.setDescription(productDTO.getDescription()); 
		
		  product.setImageName(file.getOriginalFilename());

		  Product uploadImg = new Product();

			if (uploadImg != null) {
				try {

					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		//	session.setAttribute("msg", "Image Upload Sucessfully");
		  productServe.addProduct(product);
		  
		  return "redirect:/admin/products"; }
		  
		  
		  @GetMapping("/admin/product/delete/{id}") public String
		  deleteProduct(@PathVariable long id) {
		  
		  productServe.removeProductById(id); return "redirect:/admin/products";
		  
		  }
		  
		  @GetMapping("/admin/product/update/{id}") public String
		  updateProductGet(@PathVariable long id, Model model) {
		  
		  Product product= productServe.getProductById(id).get();
		  
		  ProductDTO productDTO= new ProductDTO();
		  
		  productDTO.setId(product.getId()); productDTO.setName(product.getName());
		  productDTO.setCategoryId((product.getCategory().getId()));
		  productDTO.setPrice(product.getPrice());
		  productDTO.setWeight((product.getWeight()));
		  productDTO.setDescription(product.getDescription());
		  productDTO.setImageName(product.getImageName());
		  
		  model.addAttribute("categories", categoryServe.getAllCategory());
		  model.addAttribute("productDTO", productDTO);
		  
		  return "productsAdd";
		  
		  
		  }
		 
}


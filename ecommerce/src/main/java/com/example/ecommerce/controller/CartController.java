
package com.example.ecommerce.controller;
  
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ecommerce.global.GlobalData;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.Generator;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.Webservice;

  
@Controller
 
  public class CartController {
  
	 @Autowired 
	  private Generator generator;
  
	@Autowired
	 private Webservice webService;
	  
	  
    @Autowired 
    ProductService productServe;
	  
	
    @Value("${coupon.startdate}")
	private String startdate;
	
	@Value("${coupon.discount}")
	private String discount;
	
	@Value("${coupon.stopdate}")
	private String stopdate;
	
	
    @GetMapping("/addToCart/{id}")
  
  public String addToCart(@PathVariable int id) {
  GlobalData.cart.add(productServe.getProductById(id).get()); 
  return "redirect:/shop";
  
  }
  
  @GetMapping("/cart")
  

  public String cartGet(Model model) { 
  model.addAttribute("cartCount", GlobalData.cart.size());
 
  model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
//  model.addAttribute("discount", "1000");

  model.addAttribute("cart", GlobalData.cart); 
  
  return "cart";
  
  }
  
@RequestMapping("/coupon")


  public String coupon(Model model, @Valid String coupon) throws NoSuchAlgorithmException { 
  model.addAttribute("cartCount", GlobalData.cart.size());
 
  //double dis=Double.parseDouble(discount);

 Webservice web=new Webservice();
 
 System.out.println(coupon);
 
String getcoup= web.getCoupon(coupon);
String[] parts=getcoup.split(",");
String status=parts[0].substring(1,parts[0].length());


String discount=parts[1].substring(1,parts[1].length()-2);



System.out.println("hjfhjdsfkjdsfkj"+coupon);



System.out.println("status="+status);
//System.out.println("dis="+dis);

double dis=0;


if(status.equals("true")) {
	dis=Double.parseDouble(discount);
	model.addAttribute("discount",dis);
	System.out.println("discount"+dis);
	
}else{
	
	model.addAttribute("discount", discount);
	System.out.println("discount"+discount);
	
}


System.out.println("coupon="+getcoup);

web.usedCoupon(coupon);
model.addAttribute("usedCoupon", coupon);

model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
  model.addAttribute("finalAmount",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum()-dis);
  
 
  model.addAttribute("cart", GlobalData.cart);
  
  return "checkout";
  
  
  }
  
  @GetMapping("/cart/removeItem/{index}") 
  
  public String cartItemRemove(@PathVariable int index) {
  GlobalData.cart.remove(index); 
  return "redirect:/cart"; 
  
  }
  
	
	
	  @GetMapping("/gotocheckout") 
	  
	  public String checkout(Model model) {
	  model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
	  model.addAttribute("finalAmount",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
	  
	  return "checkout";
	  
	  }
	 
 
 @PostMapping("/checkout") 
 
 
  
  public String checkout(Model model, String username,Principal principal) throws NoSuchAlgorithmException {
	
	 model.addAttribute("finalAmount",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
	
 model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
 double price=GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();

 Webservice web=new Webservice();
// System.out.println("coupon1: " + coupon);

 
  if(price>2000) {
	  
	 
	  String coupon=webService.randomcode();
	  generator.sendSimpleEmail(principal.getName(), coupon,"Find couponid below");
	  
	 model.addAttribute("emailstatus","" + "Payment completed "
	 		+ "Congradulation... you have won the coupon code has been sent to your email Verify and make use of it until the validity date");
	 
 System.out.println("coupon1: " + coupon);
 System.out.println("startdate1: " + startdate);
 System.out.println("stopdate1: " + stopdate);
 System.out.println("discount1: " + discount);
  
  String test= web.createCoupon(startdate,stopdate,discount,coupon);

  System.out.println("test="+test);
  }else if(price>3000) {
	  
	  
	  String coupon=webService.randomcode();
	  generator.sendSimpleEmail(principal.getName(), coupon,"Find couponid below");
	 model.addAttribute("emailstatus",""
	 		+ "Payment completed "
	 		+ "Congradulation... you have won the coupon code, has been sent to your email Verify and make use of it until the validity date");
	 
 System.out.println("coupon1: " + coupon);
 System.out.println("startdate1: " + startdate);
 System.out.println("stopdate1: " + stopdate);
 System.out.println("discount1: " + discount);
  
  String test= web.createCoupon(startdate,stopdate,discount,coupon);

  System.out.println("test="+test);
  
 }else {
	 

	  model.addAttribute("payStatus","Payment Completed Successfully");
	 
  }
  
 return "checkout";
  
  }

	
}
package com.example.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class Webservice {
	
	 @Autowired
	 private JavaMailSender mailSender;
	 
	
	 
	 @Value("${spring.mail.username}")
		private String email;

	 
	public String createCoupon(String startdate, 
			String stopdate, String discount, String coupon) {
		
		
		
		RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
          = "http://localhost:8000/addCoupon";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
       // AddCoupon addcoupon=new AddCoupon();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        
        map.add("coupon",coupon);
        map.add("startdate",startdate);
        map.add("stopdate",stopdate);
        map.add("discount",discount);
        
      
        
        HttpEntity<MultiValueMap<String, String>> request = 
            new HttpEntity<>(map, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity(
                  resourceUrl, request , String.class); 

        return response.getBody();
	
		
	}
	
	 public void sendSimpleEmail(String toEmail,
             String body,
             String subject) {
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setFrom(email);
		 message.setTo(toEmail);
		 message.setText(body);
		 message.setSubject(subject);
		 mailSender.send(message);
		 System.out.println("Mail Send...");

}
	
	
	public String getCoupon(String coupon) {
		
		
		RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
          = "http://localhost:8000/getCoupon";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        
        System.out.println("++++++++++"+coupon);
       
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
       map.add("coupon", coupon);
       
       
        HttpEntity<MultiValueMap<String, String>> request = 
            new HttpEntity<>(map, headers);
        
        ResponseEntity<String> response = restTemplate.postForEntity(
                  resourceUrl, request , String.class); 

        System.out.println(response.getBody());
        
      
		
		return response.getBody();
		

}
	
	
public String randomcode() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		      HttpHeaders headers = new HttpHeaders();
		    //  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <String> entity = new HttpEntity<String>(headers);
		      
		  
		      return restTemplate.exchange("http://localhost:8082/hash", HttpMethod.GET, entity, String.class).getBody();


}
	
public String usedCoupon( 
		 String coupon) {
	
	
	
	RestTemplate restTemplate = new RestTemplate();

    String resourceUrl
      = "http://localhost:8000/addUsedCoupon";
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    
   // AddCoupon addcoupon=new AddCoupon();
    MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
    
    map.add("coupon",coupon);

    
    HttpEntity<MultiValueMap<String, String>> request = 
        new HttpEntity<>(map, headers);
    
    ResponseEntity<String> response = restTemplate.postForEntity(
              resourceUrl, request , String.class); 

    return response.getBody();

	
}



}

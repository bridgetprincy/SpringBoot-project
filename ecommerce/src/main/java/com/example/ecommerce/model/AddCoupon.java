package com.example.ecommerce.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix="coupon")
@Configuration("addCoupon")
public class AddCoupon {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

  //  @Value("${coupon.startdate}")
	private String startdate;
	
//	@Value("${coupon.discount}")
	private String discount;
	
//	@Value("${coupon.stopdate}")
	private String stopdate;
	
//	@Value("${coupon.coupon}")
	private String coupon;
	
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getStopdate() {
		return stopdate;
	}
	public void setStopdate(String stopdate) {
		this.stopdate = stopdate;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	
}

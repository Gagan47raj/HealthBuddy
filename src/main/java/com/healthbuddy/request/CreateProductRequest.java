package com.healthbuddy.request;


import java.util.HashSet;
import java.util.Set;
import com.healthbuddy.model.Vols;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
	private String name;
	private String description;
	private int price;
	private int discountedPrice;
	private int discountPercent;
	private int quantity;
	private String brand;
	private String imageUrl;
	
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	



	

}
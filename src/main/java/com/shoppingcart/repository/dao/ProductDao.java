package com.shoppingcart.repository.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ProductDao {
	
	@Id
	String _id;
	private String productId;
	@Indexed
	private String name;
	private String description;
	private String quantity;
	
	@Indexed
	private String category;
	private String price;
	private String colour;
}

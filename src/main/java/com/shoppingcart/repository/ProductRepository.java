package com.shoppingcart.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.repository.dao.ProductDao;

public interface ProductRepository extends MongoRepository<ProductDao,String>{
	

	ProductDao findByName(String name); 
	
	List<ProductDao> findByNameInOrColourInOrCategoryIn(List<String> name, List<String> colour, List<String> category); 
}

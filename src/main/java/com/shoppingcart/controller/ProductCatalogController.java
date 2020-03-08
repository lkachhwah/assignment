package com.shoppingcart.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Exception.BusinessException;
import com.shoppingcart.repository.dao.ProductDao;
import com.shoppingcart.service.ProductService;

@RestController(value = "/api")
public class ProductCatalogController {

	@Autowired
	private ProductService productService;
	Logger log = LogManager.getLogger(ProductCatalogController.class);

	@GetMapping(path = "/product")
	public ProductDao getByName(@RequestHeader(required = true) String name) throws BusinessException {
		log.info("fetch  product details b name :{}",name);
		return productService.getByName(name);
	}

	@PostMapping(path = "/product")
	public ProductDao save(@RequestBody(required = true) ProductDao productDao) throws BusinessException {
		log.info("Saving  product details :{}",productDao);
		return productService.save(productDao);
	}

	@PutMapping(path = "/product")
	public ProductDao update(@RequestBody(required = true) ProductDao productDao) throws BusinessException {
		log.info("Update  product details :{}",productDao);
		return productService.update(productDao);
	}
	
	@DeleteMapping(path = "/product")
	public ProductDao deleteByName(@RequestHeader(required = true) String name) throws BusinessException {
		log.info("delete  product details name:{}",name);
		return productService.deleteByName(name);
	}
	
	@GetMapping(path = "/product/list")
	public List<ProductDao> getListByCriteria(@RequestParam(required = false) List<String> name,
			@RequestParam(required = false) List<String> colour,
			@RequestParam(required = false) List<String> category) throws BusinessException {
		log.info("List  product details by name :{} ,colour :{} ,category :{}",name,colour,category);
		return productService.getListByCreteria(name,colour,category);
	}

}

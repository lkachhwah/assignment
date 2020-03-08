package com.shoppingcart.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.shoppingcart.Exception.BusinessException;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.repository.dao.ProductDao;
import com.shoppingcart.utils.ValidationUtils;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ValidationUtils validationUtils;

	Logger log = LogManager.getLogger(ProductService.class);

	public ProductDao getByName(String name) throws BusinessException {
		log.info("Fetching  product name :{}", name);
		ProductDao productDao = productRepository.findByName(name);
		validationUtils.validateDataPresentInDb(productDao);
		return productDao;
	}

	public ProductDao save(ProductDao productDao) throws BusinessException {
		validationUtils.validateSaveDetails(productDao);
		log.info("Saving  product details :{}", productDao);
		return productRepository.save(productDao);
	}

	public ProductDao update(ProductDao productDao) throws BusinessException {
		validationUtils.validateSaveDetails(productDao);
		log.info("Updating  product details :{}", productDao);
		ProductDao dao = productRepository.findByName(productDao.getName());
		validationUtils.validateDataPresentInDb(productDao);
		productRepository.deleteById(dao.get_id());
		return productRepository.save(productDao);
	}

	public ProductDao deleteByName(String name) throws BusinessException {
		log.info("Fetching  product name :{}", name);
		ProductDao productDao = getByName(name);
		validationUtils.validateDataPresentInDb(productDao);
		productRepository.deleteById(productDao.get_id());
		log.info("deleted  product  :{}", productDao);
		return productDao;
	}

	public List<ProductDao> getListByCreteria(List<String> name, List<String> colour, List<String> category) throws BusinessException {
		
		if(CollectionUtils.isEmpty(name))
		{
			name= new LinkedList<>();
		}
		if(CollectionUtils.isEmpty(colour))
		{
			colour= new LinkedList<>();
		}
		
		if(CollectionUtils.isEmpty(category))
		{
			category= new LinkedList<>();
		}
	
		
		 List<ProductDao> productDaoList=productRepository.findByNameInOrColourInOrCategoryIn(name,colour,category);
		
		 validationUtils.validateDataPresentInDb(productDaoList);


		return null;
	}

}

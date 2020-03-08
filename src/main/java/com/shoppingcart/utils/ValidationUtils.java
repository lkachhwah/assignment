package com.shoppingcart.utils;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.shoppingcart.Exception.BusinessException;
import com.shoppingcart.repository.dao.ProductDao;

@Component
public class ValidationUtils {

	@Value("${validate.name.length:100}")
	private int nameLength;

	@Value("${validate.description.length:100}")
	private int descriptionLength;

	public void validateSaveDetails(ProductDao productDao) throws BusinessException {
		if (Objects.nonNull(productDao)) {
			ValidateName(productDao);
			ValidateDescription(productDao);

		}

		else {
			throw new BusinessException("Product deatial cannot be empty", BusinessException.DATA_VALIDATE_ISSUE);
		}
	}

	private void ValidateName(ProductDao productDao) throws BusinessException {
		if (StringUtils.isEmpty(productDao.getName()) || nameLength < productDao.getName().length()) {
			throw new BusinessException("Product deatials name cannot be empty or greter than size :" + nameLength,
					BusinessException.DATA_VALIDATE_ISSUE);
		}
	}

	private void ValidateDescription(ProductDao productDao) throws BusinessException {
		if (StringUtils.isEmpty(productDao.getDescription())
				|| descriptionLength < productDao.getDescription().length()) {
			throw new BusinessException(
					"Product details Description cannot be empty or greter than size :" + descriptionLength,
					BusinessException.DATA_VALIDATE_ISSUE);
		}
	}

	public void validateDataPresentInDb(ProductDao productDao) throws BusinessException {
		if (Objects.isNull(productDao) && StringUtils.isEmpty(productDao.get_id())) {
			throw new BusinessException("Product detail not present in DB", BusinessException.DATA_MISSING_IN_DB);
		}
	}

	public void validateDataPresentInDb(List<ProductDao> productDaoList) throws BusinessException {
		if(CollectionUtils.isEmpty(productDaoList))
		{
			throw new BusinessException("Product detail not present in DB",BusinessException.DATA_MISSING_IN_DB);
		}
				
	}

}

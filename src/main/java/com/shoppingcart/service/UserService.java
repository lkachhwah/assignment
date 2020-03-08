/*package com.shoppingcart.service;

import java.util.Objects;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingcart.Exception.BusinessException;
import com.shoppingcart.model.User;
import com.shoppingcart.repository.UserRepository;
import com.shoppingcart.repository.dao.UserDao;

@Service
public class UserService {

	
	ObjectMapper objectMapper= new ObjectMapper();
	
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String Uname)
	{
		UserDao userDao=userRepository.getUserByuname(Uname);
		if(Objects.nonNull(userDao))
		{
		return objectMapper.convertValue(userRepository.getUserByuname(Uname),User.class);
		}
		throw new BusinessException("User detail not found","100");
	}
}
*/
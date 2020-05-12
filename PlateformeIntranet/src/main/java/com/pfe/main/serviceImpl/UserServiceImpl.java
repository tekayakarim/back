package com.pfe.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.JwtUser;
import com.pfe.main.repository.JwtUserRepository;
import com.pfe.main.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	JwtUserRepository jwtUserRepository;

	@Override
	public List<JwtUser> listerAllUsers() {
		return jwtUserRepository.findAll();
	}

	@Override
	public String deleteUser(long id) {
		JwtUser user = jwtUserRepository.findByid(id);
		user.setRoles(null);
		jwtUserRepository.flush();
		jwtUserRepository.deleteById(id);
		if(jwtUserRepository.findById(id)==null)
			return "user deleted";
		return "error: user found";
	}

}
package com.codifers.api.chat.codiferschat.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codifers.api.chat.codiferschat.business.domain.ResponseDTO;
import com.codifers.api.chat.codiferschat.business.domain.UserDTO;
import com.codifers.api.chat.codiferschat.data.entity.User;
import com.codifers.api.chat.codiferschat.data.repository.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public ResponseDTO save(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setUserName(userDTO.getUserName());
		userRepository.save(user);
		
		ResponseDTO response = new ResponseDTO();
		response.setStatus("100");
		response.setDescription("Success");
		
		return response;
	}
	
	public List<User> getAllUsersExceptMe(User currentUser){
		
		List<User> userList = new ArrayList<User>();
		Iterable<User> users = userRepository.findAll();
		
		users.forEach(userList::add);
		
		for(int i = 0;i<userList.size();i++) {
			if(userList.get(i).getUserName().equals(currentUser.getUserName())) {
				userList.remove(i);
				break;
			}
		}
		
		return userList;
	}
	

}

package com.project.manager.projectmanagerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.projectmanagerapi.modal.User;
import com.project.manager.projectmanagerapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
//	public Object updateUser(User user) {
//		return userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getEmployeeId());
//	}

    public User updateUser(User user){
        User oldUser = userRepository.findByEmployeeId(user.getEmployeeId());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        return userRepository.save(oldUser);
    }
}

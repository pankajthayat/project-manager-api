package com.project.manager.projectmanagerapi.service;

import com.project.manager.projectmanagerapi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.projectmanagerapi.modal.User;
import com.project.manager.projectmanagerapi.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
//	public Object updateUser(User user) {
//		return userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getEmployeeId());
//	}

    public User updateUser(User user) throws UserNotFoundException{
        Optional<User> oldUser = userRepository.findById(user.getUserId());
        if(!oldUser.isPresent())
            throw new UserNotFoundException("user not found");
        oldUser.get().setFirstName(user.getFirstName());
        oldUser.get().setLastName(user.getLastName());
        oldUser.get().setEmployeeId(user.getEmployeeId());
        return userRepository.save(oldUser.get());
    }
}

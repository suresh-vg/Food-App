package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.UserRepository;

@Repository
public class UserDao {
	
	private static final Optional<User> User = null;

	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		System.out.println(user);
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public User getUser(User user) {
		User currentUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(currentUser != null) {
			return currentUser;
		}
		return null;
	}
	
	public User updateUser(User user,int id) {
		user.setId(id);
		return userRepository.save(user);
	}

	public String deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return "User has been deleted";
		}
		
		return "User Id dosen't exists";
	}

	public Optional<User> findByUsername(String username) {
		Optional<User> user = userRepository.findByName(username);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return user;
		}
		return null;
	}

	public List<User> getStaff() {
		List<User> user= userRepository.findByRole("STAFF");
		if(!user.isEmpty()) {
			return user;
		}
		return null;
	}

	public User isEmailRegistered(String email) {
		User user= userRepository.findByEmail(email);
		if(user != null) {
			return user;
		}
		return null;
	}

}
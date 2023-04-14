package com.clarivate.foodapp.repository;





import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailAndPassword(String email,String password);

	public Optional<User> findByName(String username);
	
	public List<User> findByRole(String role);

	public User findByEmail(String email);

}

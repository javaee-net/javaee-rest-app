package net.javaaee.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaaee.restapp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	
}
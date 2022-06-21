package com.codifers.api.chat.codiferschat.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codifers.api.chat.codiferschat.data.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}

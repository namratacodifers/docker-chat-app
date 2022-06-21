
package com.codifers.api.chat.codiferschat.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codifers.api.chat.codiferschat.data.entity.Message;
import com.codifers.api.chat.codiferschat.data.entity.User;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	/*
	 * public Iterable<Message> findAllByMsgFrom(User msgFrom);
	 * 
	 * public Iterable<Message> findAllByMsgTo(User msgTo);
	 */
	
	public Iterable<Message> findAllByMsgFromAndMsgTo(User msgFrom,User msgTo);
}

package com.codifers.api.chat.codiferschat.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codifers.api.chat.codiferschat.business.domain.MessageDTO;
import com.codifers.api.chat.codiferschat.business.domain.MessageFromToDTO;
import com.codifers.api.chat.codiferschat.data.entity.Message;
import com.codifers.api.chat.codiferschat.data.repository.MessageRepository;
import com.codifers.api.chat.codiferschat.util.MessageComparator;

@Service
public class MessageService {

	private final MessageRepository messageRepository;
	
	@Autowired
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public void save(MessageDTO messageDTO) {
		
		
		Message message = new Message();
		message.setMessage(messageDTO.getMessage());
		message.setMsgFrom(messageDTO.getMsgFrom());
		message.setDateTime(messageDTO.getDateTime());
		message.setMsgTo(messageDTO.getMsgTo());
		messageRepository.save(message);
	
	}
	
	public List<Message> getAllMessage(MessageFromToDTO messageDTO) {
		
		
		Iterable<Message> messages = messageRepository.findAllByMsgFromAndMsgTo(messageDTO.getMsgFrom(), messageDTO.getMsgTo());
		
		Iterable<Message> messages1 = messageRepository.findAllByMsgFromAndMsgTo(messageDTO.getMsgTo(), messageDTO.getMsgFrom());
		
		List<Message> chats = new ArrayList<Message>();
		
		messages.forEach(chats::add);
		messages1.forEach(chats::add);
		
		Collections.sort(chats, new MessageComparator());
		
		return chats;
		
	}
}

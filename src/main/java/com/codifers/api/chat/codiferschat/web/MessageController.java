package com.codifers.api.chat.codiferschat.web;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codifers.api.chat.codiferschat.business.domain.MessageDTO;
import com.codifers.api.chat.codiferschat.business.domain.MessageFromToDTO;
import com.codifers.api.chat.codiferschat.business.domain.UserDTO;
import com.codifers.api.chat.codiferschat.business.service.MessageService;
import com.codifers.api.chat.codiferschat.data.entity.Message;
  
@RestController
public class MessageController {
	  
	
	@Autowired 
	private SimpMessagingTemplate simpMessagingTemplate;
	 	
	@Autowired
	private MessageService messageService;
			  
	
	  @MessageMapping("/chatCodifers/{to}") 
	  public void msg(@DestinationVariable String to, @Payload MessageDTO message) { 
		  save(message);
		  this.simpMessagingTemplate.convertAndSend("/topic/messages/"+to, message); 
	  }
	 
	
	@PostMapping("/save-message")
	public void save(@RequestBody MessageDTO message){
		
		messageService.save(message);
		
	}
	
	@PostMapping("/get-all-messages")
	public List<Message> getAllMessages(@RequestBody MessageFromToDTO messageFromToDTO) {
		
		return messageService.getAllMessage(messageFromToDTO);
	}
	  
 }
 
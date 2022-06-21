package com.codifers.api.chat.codiferschat.business.domain;

import java.time.LocalDateTime;

import com.codifers.api.chat.codiferschat.data.entity.User;

public class MessageDTO {
	
	private String message;
	private LocalDateTime dateTime;
	private User msgFrom;
	private User msgTo;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getMsgFrom() {
		return msgFrom;
	}

	public void setMsgFrom(User msgFrom) {
		this.msgFrom = msgFrom;
	}

	public User getMsgTo() {
		return msgTo;
	}

	public void setMsgTo(User msgTo) {
		this.msgTo = msgTo;
	}



	
}

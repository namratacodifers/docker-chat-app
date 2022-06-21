package com.codifers.api.chat.codiferschat.business.domain;

import com.codifers.api.chat.codiferschat.data.entity.User;

public class MessageFromToDTO {
	
	private User msgFrom;
	private User msgTo;
	
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

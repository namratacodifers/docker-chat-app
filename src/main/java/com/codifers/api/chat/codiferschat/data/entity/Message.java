package com.codifers.api.chat.codiferschat.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name = "id")
	private long id;
	
	@Column(name = "message" , nullable = false)
	private String message;
	
	@Column(name = "sent_time" , nullable = false)
	private LocalDateTime dateTime;
	
	@ManyToOne
	private User msgFrom;
	
	@ManyToOne
	private User msgTo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", dateTime=" + dateTime + ", msgFrom=" + msgFrom
				+ ", msgTo=" + msgTo + "]";
	}
	
	
}

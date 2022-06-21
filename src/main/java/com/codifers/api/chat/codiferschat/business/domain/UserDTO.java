package com.codifers.api.chat.codiferschat.business.domain;

public class UserDTO {
	
	
	private long id;
	
	private String name;
	
	private String userName;
	
	public UserDTO() {
		
	}
	
	public UserDTO(long id, String name, String userName) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}

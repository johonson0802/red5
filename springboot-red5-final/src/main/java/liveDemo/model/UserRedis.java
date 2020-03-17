package liveDemo.model;

import java.io.Serializable;

public class UserRedis implements Serializable{
	private static final long serialVersionUID = 1308172982856088184L;
	
	private String name;
	private String password;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

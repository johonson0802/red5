package liveDemo.model;

import java.io.Serializable;

public class LiveRedis implements Serializable{
	private static final long serialVersionUID = -7311696945203955533L;
	
	private String liveName;
	private String userName;
	private String keyName;
	private String content;
	
	public String getLiveName() {
		return liveName;
	}
	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

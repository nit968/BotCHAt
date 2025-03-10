package com.example.chat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ChatMessage {
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String username;
    private String content;
	@Override
	public String toString() {
		return "ChatMessage [username=" + username + ", content=" + content + "]";
	}
	public ChatMessage(String username, String content) {
		super();
		this.username = username;
		this.content = content;
	}
    
}

package com.jrp.pma.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="user_accounts")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_accounts_seq")
	@SequenceGenerator(name = "user_accounts_seq", sequenceName = "user_accounts_seq", allocationSize = 1)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name="username")
	private String userName;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private boolean enabled = true;
	
	public UserAccount() {
		
	}
	
	public UserAccount(String userName, String email, String password, boolean enabled) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

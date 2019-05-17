package br.com.philipe.seguranca;

import java.io.Serializable;

public class UserLogin implements Serializable{

	private static final long serialVersionUID = 2916757869841926032L;

	private String userName;
	
	private String password;

	/**
	 * Construtor.
	 */ 	
	public UserLogin() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param userName
	 * @param password
	 */
	public UserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	//GET SET
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

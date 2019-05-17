package br.com.philipe.seguranca;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -6957944673162440232L;

	private String name;

	//GET SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

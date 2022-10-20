package com.br.intelipost.intelipost.model.enums;

public enum LoginRole{
	
	FULL("FULL"),
	NORMAL("NORMAL"),
	RESTRICT("RESTRICT");
	
	private final String value;
	
	LoginRole(final String s) {
		this.value = s;
	}
	public String toString() {
		return this.value;
	}
	
}
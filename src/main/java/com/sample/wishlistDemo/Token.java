package com.sample.wishlistDemo;

public class Token {
	
	private static Token token = new Token();
	private String accessToken;
	
	private Token(){}
	
	public static Token getInstance(){
		return token;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}

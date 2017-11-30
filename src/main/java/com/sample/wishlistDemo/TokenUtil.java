package com.sample.wishlistDemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class TokenUtil {

	public static void main(String[] args) {
		

	}
	
	public static String getAccessToken(){
		Token token = Token.getInstance();
		if (token.getAccessToken() != null){
			return token.getAccessToken();
		}
		
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(factory);
        
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
        headers.setContentType(type);
                
        String str = "grant_type=client_credentials&client_id=R64UWNPnzFwkg74XAYiVc6mWpB0Qtu1R&client_secret=EEmhYGZXGXPkjBpH&scope=hybris.document_manage";
        
        HttpEntity<String> formEntity = new HttpEntity<String>(str, headers);

        String url = "https://api.beta.yaas.io/hybris/oauth2/v1/token";
        String result = restTemplate.postForObject(url, formEntity, String.class);
        
        Token.getInstance().setAccessToken(result);
        
        return result;
	}
	
	public static void saveDocument(){
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(factory);
        
        String bearer = Token.getInstance().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + bearer);
        String url = "";
        String data = "";
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        
        ResponseEntity<String> reponse = restTemplate.postForEntity(url, formEntity, String.class);
        
        
	}
	

}

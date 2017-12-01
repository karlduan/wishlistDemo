package com.sample.wishlistDemo.utils;

import com.sample.wishlistDemo.constants.Constants;
import com.sample.wishlistDemo.pojos.Token;

public class TokenUtil {
	
	private final static TokenUtil INSTANCE=new TokenUtil();
	
	private TokenUtil(){
		
	}
	public static TokenUtil getInstance(){
		return INSTANCE;
	}
	
	public static String getAccessToken(){
        String jsonData = RestTemplateUtil.postForToken(Constants.AUTH_TOKEN_URL, Constants.AUTH_STR);
        Token token = JSONUtil.parseObject(jsonData,Token.class );
        return token.getAccess_token();
	}
	
	public static void main(String[] args) {
	    System.out.println("Token string is "+getAccessToken());
    }
	
//	public static String getAccessToken(){
//        Token token = Token.getInstance();
//        if (token.getAccessToken() != null){
//            return token.getAccessToken();
//        }
//        
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        RestTemplate restTemplate = new RestTemplate(factory);
//        
//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
//        headers.setContentType(type);
//                
//        String str = "grant_type=client_credentials&client_id=R64UWNPnzFwkg74XAYiVc6mWpB0Qtu1R&client_secret=EEmhYGZXGXPkjBpH&scope=hybris.document_manage";
//        
//        HttpEntity<String> formEntity = new HttpEntity<String>(str, headers);
//
//        String url = "https://api.beta.yaas.io/hybris/oauth2/v1/token";
//        String result = restTemplate.postForObject(url, formEntity, String.class);
//        
//        Token.getInstance().setAccessToken(result);
//        
//        return result;
//    }
	
//	public static void saveDocument(){
//		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        RestTemplate restTemplate = new RestTemplate(factory);
//        
//        String bearer = Token.getInstance().getAccessToken();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + bearer);
//        String url = "";
//        String data = "";
//        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
//        
//        ResponseEntity<String> reponse = restTemplate.postForEntity(url, formEntity, String.class);
//	}
	

}

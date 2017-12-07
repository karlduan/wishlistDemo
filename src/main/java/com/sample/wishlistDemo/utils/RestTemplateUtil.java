package com.sample.wishlistDemo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.sample.wishlistDemo.constants.Constants;

public class RestTemplateUtil {
	
	private static class SingletonRestTemplate {
	    static final RestTemplate INSTANCE = new RestTemplate();
    }

	private RestTemplateUtil (){
		
	}
	public static RestTemplate getInstance() {
	    return SingletonRestTemplate.INSTANCE;
	
	}
	
	public static String post(String uri, String data){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + TokenUtil.getAccessToken(Constants.SCOPE.DOCUMENT_MANAGE));
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(Constants.BASE_URL+uri, formEntity, String.class);
    }
	
	public static String get(String uri){
		HttpHeaders headers = new HttpHeaders();
		String token=TokenUtil.getAccessToken(Constants.SCOPE.DOCUMENT_VIEW);
		headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> formEntity = new HttpEntity<String>(headers);
		RestTemplateUtil.getInstance().setErrorHandler(new ResponseErrorHandler(token));
		return RestTemplateUtil.getInstance().getForObject(Constants.BASE_URL+uri,String.class,formEntity);
	}
	
	public static String postForToken(String url, String data){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(url, formEntity, String.class);
    }
	
	public static void main(String[] args) {
//	    Wishlist wishlist = new Wishlist();
//	    wishlist.setOwner("C6724366777");	    
        String ret = get("/wishlists"+"/C6724366777");
        System.out.println("wishlists is "+ret);
//        post(uri, data)
//        getByOwner(url, owner)
        
    }	

    public static String getById(String url, String id) {
        return RestTemplateUtil.getInstance().getForObject(url, String.class,
                id);
    }
    
    public static String getByOwner(String url, String owner) {
        return RestTemplateUtil.getInstance().getForObject(url, String.class,
                owner);
    }

    
    public void put(String url, String data) {
        RestTemplateUtil.getInstance().put(url, null, data);
    }

    public void delete(String url, String id) {
        RestTemplateUtil.getInstance().delete(url, id);
    }
	
	
}

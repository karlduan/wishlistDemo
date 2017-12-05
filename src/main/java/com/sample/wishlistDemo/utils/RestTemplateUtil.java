package com.sample.wishlistDemo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.sample.wishlistDemo.api.generated.Wishlist;
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
	
	public static String post(String url, String data){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + TokenUtil.getAccessToken(Constants.SCOPE.DOCUMENT_MANAGE));
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(url, formEntity, String.class);
    }
	
	public static String get(String url){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer " + TokenUtil.getAccessToken(Constants.SCOPE.DOCUMENT_VIEW));
		HttpEntity<String> formEntity = new HttpEntity<String>(headers);		
		return RestTemplateUtil.getInstance().postForObject(Constants.BASE_URL+url, formEntity, String.class);
	}
	
	public static String postForToken(String url, String data){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(url, formEntity, String.class);
    }
	
	public static void main(String[] args) {
	    Wishlist wishlist = new Wishlist();
	    wishlist.setOwner("C6724366777");	    
        String ret = get(Constants.BASE_URL+"wishlists");
        System.out.println("wishlists is "+ret);
        
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

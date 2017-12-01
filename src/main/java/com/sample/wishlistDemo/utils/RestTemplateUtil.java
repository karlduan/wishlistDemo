package com.sample.wishlistDemo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

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
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.set("Authorization", "Bearer " + TokenUtil.getAccessToken());
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(url, formEntity, String.class);
    }
	
	public static String postForToken(String url, String data){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtil.getInstance().postForObject(url, formEntity, String.class);
    }
	
	public static void main(String[] args) {
        
    }
	
    public String get(String url) {
        return RestTemplateUtil.getInstance().getForObject(url, String.class,
                new Object[] {});
    }

    public String getById(String url, String id) {
        return RestTemplateUtil.getInstance().getForObject(url, String.class,
                id);
    }

    
    public void put(String url, String data) {
        RestTemplateUtil.getInstance().put(url, null, data);
    }

    public void delete(String url, String id) {
        RestTemplateUtil.getInstance().delete(url, id);
    }
	
	
}

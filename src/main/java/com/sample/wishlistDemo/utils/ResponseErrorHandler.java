package com.sample.wishlistDemo.utils;

import java.io.IOException;

import javax.ws.rs.InternalServerErrorException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.sample.wishlistDemo.exception.TokenException;

public class ResponseErrorHandler extends DefaultResponseErrorHandler {
    
    private String token;
    public ResponseErrorHandler(String token) {
        this.token=token;
    }
    
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        switch (response.getRawStatusCode()) {
            case 401:
                throw new TokenException("unauthorized token"+token);
                
            case 403:
                throw new TokenException("forbiden token" +token);
            default:
                throw new InternalServerErrorException("Server internal error! token" +token);
        }
    }
    

}

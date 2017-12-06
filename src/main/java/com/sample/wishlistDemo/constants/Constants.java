package com.sample.wishlistDemo.constants;

public class Constants {
    public static final String BASE_TOKE_DATA="grant_type=client_credentials"
    		+ "&client_id=R64UWNPnzFwkg74XAYiVc6mWpB0Qtu1R"
    		+ "&client_secret=EEmhYGZXGXPkjBpH&Tenat=caashiring";
    public static final String MANAGE_SCOPE_TOKEN_DATA=BASE_TOKE_DATA+"&scope=hybris.document_manage";
    public static final String VIEW_SCOPE_TOKEN_DATA=BASE_TOKE_DATA+"&scope=hybris.document_view";
    public static final String AUTH_TOKEN_URL="https://api.beta.yaas.io/hybris/oauth2/v1/token";
    public static final String BASE_URL="https://api.beta.yaas.io/hybris/document/v1/caashiring/caashiring.test/data/";
    public enum SCOPE {
    	DOCUMENT_MANAGE, DOCUMENT_VIEW  
    	}
}

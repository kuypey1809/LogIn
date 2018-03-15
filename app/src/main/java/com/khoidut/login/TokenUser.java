package com.khoidut.login;

/**
 * Created by Khoi on 3/10/2018.
 */

public class TokenUser {
    private String token_type;
    private String expires_in;
    private String access_token;
    private String refresh_token;

    public TokenUser (String token_type, String expires_in, String access_token, String refresh_token) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public String getExpires_in() {
        return this.expires_in;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getToken_type() {
        return this.token_type;
    }
}

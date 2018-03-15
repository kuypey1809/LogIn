package com.khoidut.login;

import java.util.List;

public class User {
    public String id;
    public String userName;
    public String email;
    public String password;
    public String access_token;
    private List<TokenUser> token;

    public User(String id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TokenUser> getToken() {
        return this.token;
    }

    public void setToken(List<TokenUser> token) {
        this.token = token;

        for (int i = 0; i < this.token.size(); i++) {
            this.access_token = this.token.get(i).getAccess_token();
        }
    }
}
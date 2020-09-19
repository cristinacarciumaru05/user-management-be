package com.user.demo.auth;

import com.user.demo.bean.Tbu4001;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider {

    private Tbu4001 user;

    public Tbu4001 getUser() {
        return this.user;
    }

    public void setUser(Tbu4001 user) {
        this.user = user;
    }
}

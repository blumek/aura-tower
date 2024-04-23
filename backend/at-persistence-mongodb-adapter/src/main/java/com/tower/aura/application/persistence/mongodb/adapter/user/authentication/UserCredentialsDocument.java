package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class UserCredentialsDocument {
    @Id
    private String userIdentifier;
    private String username;
    private String password;

    private UserCredentialsDocument() {}

    public UserCredentialsDocument(String userIdentifier, String username, String password) {
        this.userIdentifier = userIdentifier;
        this.username = username;
        this.password = password;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof UserCredentialsDocument that)) return false;
        return Objects.equals(userIdentifier, that.userIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdentifier);
    }
}

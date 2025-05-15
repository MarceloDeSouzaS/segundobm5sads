package com.example.jwt.model;

public enum EnumRole {
    ADMIN("admin"),
    USER("user");


    private final String role;

    EnumRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

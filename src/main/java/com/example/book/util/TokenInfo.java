package com.example.book.util;

public class TokenInfo {
    private Long userId;

    public TokenInfo(Long userId) {
        //this.userEmail = userEmail;
        this.userId = userId;
    }

    // Getters and setters
    // public String getUserEmail() {
    //     return userEmail;
    // }

    // public void setUserEmail(String userEmail) {
    //     this.userEmail = userEmail;
    // }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

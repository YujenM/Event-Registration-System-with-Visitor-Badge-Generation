package com.example.demo.payload.Response;
import com.example.demo.model.*;

public class ApiResponse {
    private String message;
    private User data;

    public ApiResponse(String message, User data) {
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}

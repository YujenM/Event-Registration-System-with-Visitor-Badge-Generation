package com.example.demo.routes;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.payload.Response.ApiResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/register")
public class UserController {

    private static final String UPLOAD_DIR = "/home/yujen/uploads";

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("photo") MultipartFile photo
            ) {

        String filePath = "";

        if (userService.emailExists(email)) {
            return ResponseEntity.badRequest().body("Email already in use.");
        }
        if (userService.phoneExists(phone)) {
            return ResponseEntity.badRequest().body("Phone number already in use.");
        }

        System.out.println("File Name: " + photo.getOriginalFilename());
        System.out.println("File Size: " + photo.getSize());
        System.out.println("Content Type: " + photo.getContentType());


        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverFile = new File(dir, photo.getOriginalFilename());
            photo.transferTo(serverFile);

            filePath = serverFile.getAbsolutePath();

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Photo Upload Failed");
        }

        User newUser = new User(fullName, email, phone, filePath);
        userService.registerUser(newUser);

        ApiResponse response = new ApiResponse("User Registered Successfully", newUser);

        return ResponseEntity.ok(response);
    }
}



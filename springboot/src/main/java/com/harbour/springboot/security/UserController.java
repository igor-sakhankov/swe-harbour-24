package com.harbour.springboot.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<String> user(
            @RequestHeader(AUTHORIZATION) final String authorization,
            @RequestHeader("x-user-id") final String customHeader
    ) {
        var auth = parseAuthToken(authorization);
        if(auth) {
            return ok("user");
        }

        return status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }



    private boolean parseAuthToken(String token) {
        String basic = token.replace("Basic ", "");
        //go to database and check if the token is valid
        // the user is active
        // get user_id
        byte[] credDecoded = Base64.getDecoder().decode(basic);
        String credentials = new String(credDecoded);
        String username = credentials.split(":")[0];
        String password = credentials.split(":")[1];

        if(username.equals("john") && password.equals("12345")) {
            return true;
        } else {
            return false;
        }
    }

}


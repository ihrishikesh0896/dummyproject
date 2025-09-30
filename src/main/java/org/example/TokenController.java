package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TokenController {

    @Value("${auth.token}")
    private String configuredToken;

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken() {
        if (configuredToken != null && !configuredToken.isEmpty()) {
            return ResponseEntity.ok("Token is valid. GitHub authenticated.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is missing or invalid.");
        }
    }
}

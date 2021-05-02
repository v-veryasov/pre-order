package ru.edu.iorder.preorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.iorder.preorder.dto.AuthReqDto;
import ru.edu.iorder.preorder.security.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    //@PostMapping("/signUp")
    //public ResponseEntity<?> signUp(@RequestBody AuthReqDto reqDto) {
    //
    //}

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody AuthReqDto reqDto) {
        return ResponseEntity.ok(authService.signIn(reqDto));
    }

//    @PostMapping("/logout")
}

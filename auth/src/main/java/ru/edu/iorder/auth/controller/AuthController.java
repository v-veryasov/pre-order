package ru.edu.iorder.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.iorder.auth.dto.UserDto;
import ru.edu.iorder.auth.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authService.signUp(userDto));
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody UserDto userDto) {
        // изменить ответ в виде json
        return ResponseEntity.ok(authService.signIn(userDto));
    }

    //@PostMapping("/signOut")
    //public ResponseEntity<?> signOut(@RequestBody UserDto userDto) {
    //    return ResponseEntity.ok(authService.signIn(userDto));
    //}
}

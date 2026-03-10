package br.com.felipe.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/")
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
       return ResponseEntity.ok(service.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> list() {
        return ResponseEntity.ok(service.listAll());
    }
}
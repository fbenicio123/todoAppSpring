package br.com.felipe.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }


    @PostMapping("/")
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity userModel) {
       return ResponseEntity.ok(service.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> list() {
        return ResponseEntity.ok(service.listAll());
    }
}
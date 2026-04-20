package br.com.felipe.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> put(@PathVariable UUID id, @RequestBody UserEntity userModel) {
        userModel.setId(id);
        return ResponseEntity.ok(service.put(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> list() {
        return ResponseEntity.ok(service.listAll());
    }
}
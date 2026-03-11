package br.com.felipe.demo.user;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    public List<UserEntity> listAll() {
        return repository.findAll();
    }
}

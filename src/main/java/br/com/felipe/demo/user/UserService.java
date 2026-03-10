package br.com.felipe.demo.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserModel save(UserModel user) {
        return repository.save(user);
    }

    public List<UserModel> listAll() {
        return repository.findAll();
    }
}

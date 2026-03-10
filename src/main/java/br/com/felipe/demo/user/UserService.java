package br.com.felipe.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserModel save(UserModel user) {
        return repository.save(user);
    }

    public List<UserModel> listAll() {
        return repository.findAll();
    }
}

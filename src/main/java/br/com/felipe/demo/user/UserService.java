package br.com.felipe.demo.user;

import org.springframework.stereotype.Service;

import br.com.felipe.demo.user.event.UserEvent;
import br.com.felipe.demo.user.event.UserEventProducer;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// @Service
// public class UserService {
//     private final UserRepository repository;

//     public UserService(UserRepository repository){
//         this.repository = repository;
//     }

//     public UserEntity save(UserEntity user) {
//         return repository.save(user);
//     }

//     public List<UserEntity> listAll() {
//         return repository.findAll();
//     }
// }

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserEventProducer eventProducer;

    public UserService(UserRepository userRepository, UserEventProducer eventProducer){
        this.userRepository = userRepository;
        this.eventProducer = eventProducer;
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity delete(UUID id) {
        UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        UserEvent event = new UserEvent(id, "DELETED", user.getEmail(), user.getName(), LocalDateTime.now());
        eventProducer.publishUserEvent(event);
        return user;
    }

    public UserEntity put(UserEntity user) {
        userRepository.save(user);
        return user;
    }

    public List<UserEntity> listAll() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        UserEntity saved = userRepository.save(user);

        UserEvent event = new UserEvent(saved.getId(), "CREATED", saved.getEmail(), saved.getName(), LocalDateTime.now());
        eventProducer.publishUserEvent(event);
        return saved;
    }
}
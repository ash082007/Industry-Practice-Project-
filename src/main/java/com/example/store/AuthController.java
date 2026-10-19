package com.example.store;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

// 1. User Entity (package-private class)
@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}

// 2. User Repository (package-private interface)
interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

// 3. Main Public Controller (Matches filename AuthController.java)
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginReq) {
        Optional<User> userOpt = userRepository.findByUsername(loginReq.getUsername());

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginReq.getPassword())) {
            return ResponseEntity.ok(Map.of("message", "Login successful", "username", userOpt.get().getUsername()));
        }

        return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
    }
}

package com.example.share.demo.interfaces.http;

import com.example.share.demo.domain.user.entity.User;
import com.example.share.demo.domain.user.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/4/9 14:50
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserApi {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> queryUser(@RequestParam String name) {
        List<User> userList = userRepository.findByNameEquals(name);
        if (userList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        userOptional.ifPresent(userRepository::delete);

        user.setId(null);
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @PatchMapping
    public ResponseEntity<User> patchUpdateUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

}

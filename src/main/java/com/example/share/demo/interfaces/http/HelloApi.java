package com.example.share.demo.interfaces.http;

import com.example.share.demo.domain.user.entity.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/7/28 11:19
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/dockers")
public class HelloApi {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello docker");
    }

}

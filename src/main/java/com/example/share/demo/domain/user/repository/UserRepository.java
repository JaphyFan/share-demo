package com.example.share.demo.domain.user.repository;

import com.example.share.demo.domain.user.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

/**
 * @author Japhy
 * @since 2021/4/9 14:49
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameEquals(@NonNull String name);
}

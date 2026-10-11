package net.engineeringdigest.journalapp.repository;

import net.engineeringdigest.journalapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// In-memory store (no database); data is lost on restart.
@Repository
public class UserRepository {

    private final Map<String, UserEntity> users = new ConcurrentHashMap<>();

    public UserEntity save(UserEntity user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        users.put(user.getUsername(), user);
        return user;
    }

    public UserEntity findByUsername(String username) {
        return users.get(username);
    }
}

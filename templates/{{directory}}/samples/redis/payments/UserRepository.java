package {{directory_path_code}}.samples.redis.payments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    /**
     * Just a simple In-Memory Database
     */
    private final Map<UUID, User> DATABASE = new ConcurrentHashMap<>();

    public User save(User user) {
        LOGGER.info(
                "Persisting a new User into database..."
        );
        DATABASE.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return DATABASE.values()
                .stream()
                .toList();

    }

    public void deleteAll() {
        LOGGER.info(
                "Deleting all User from database..."
        );
        DATABASE.clear();
    }

    public int count() {
        return DATABASE.size();
    }

    public Optional<User> findById(UUID id) {
         LOGGER.info(
                "Finding User by Id into database..."
        );
        return Optional.ofNullable(DATABASE.get(id));
    }
}

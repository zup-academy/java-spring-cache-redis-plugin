package {{directory_path_code}}.samples.redis.base;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers @DirtiesContext
public abstract class RedisIntegrationTest {
    private static DockerImageName REDIS_IMAGE = RedisContainer.DEFAULT_IMAGE_NAME
            .withTag(RedisContainer.DEFAULT_TAG);

    @Container
    public static RedisContainer REDIS_CONTAINER = new RedisContainer(REDIS_IMAGE);


    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.host",
                () -> REDIS_CONTAINER.getHost());
        registry.add("spring.redis.port",
                () -> REDIS_CONTAINER.getFirstMappedPort());
    }
}

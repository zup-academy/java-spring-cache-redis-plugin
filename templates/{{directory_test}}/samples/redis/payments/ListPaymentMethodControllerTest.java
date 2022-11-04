package {{directory_path_code}}.samples.redis.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.redis.cache.CacheStatistics;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.web.servlet.MockMvc;
import {{directory_path_code}}.samples.redis.base.RedisIntegrationTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc(printOnlyOnFailure = false)
class ListPaymentMethodControllerTest extends RedisIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RedisCacheManager cacheManager;
    @Autowired
    private UserRepository repository;
    private RedisCache cache;

    @BeforeEach
    void setUp() {
        this.cache = (RedisCache) cacheManager.getCache("user_payment_methods");
        cache.clearStatistics();
        cache.clear();
    }


    @Test
    @DisplayName("must list the customer's payment methods, and after the first call cache the result")
    void name() throws Exception {
        //scenary
        User user = new User("Jordi H");
        repository.save(user);

        //action
        int hit = 5;
        for (int i = 0; i < hit; i++) {
            mockMvc.perform(
                            get("/users/{id}/payment-methods", user.getId())
                    )
                    .andExpect(
                            status().isOk()
                    );
        }

        //validation
        CacheStatistics statistics = cache.getStatistics();
        assertEquals(hit - 1, statistics.getHits());
        assertEquals(1, statistics.getMisses());
    }


    @Test
    @DisplayName("must not list payment methods for non-existent customers")
    void t2() throws Exception {

        Exception resolvedException = mockMvc.perform(
                        get("/users/{id}/payment-methods", UUID.randomUUID())
                )
                .andExpect(
                        status().isNotFound()
                ).andReturn()
                .getResolvedException();

        assertThat(resolvedException)
                .hasMessageContaining("User not exists");
    }
}
package {{directory_path_code}}.samples.redis.payments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import {{directory_path_code}}.samples.redis.base.RedisIntegrationTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc(printOnlyOnFailure = false)
class RegisterPaymentMethodToUserControllerTest extends RedisIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository repository;
    @Autowired
    private RedisCacheManager cacheManager;
    private RedisCache cache;

    @BeforeEach
    void setUp() {
        this.cache = (RedisCache) cacheManager.getCache("user_payment_methods");
        cache.clearStatistics();
        cache.clear();
    }

    @Test
    @DisplayName("must add a payment method to the user and invalidate the cache")
    void t1() throws Exception {
        //scenary
        User user = new User("Jordi");
        repository.save(user);

        List<PaymentMethod> paymentMethods = List.of(
                new PaymentMethod("Credit card", "xx"),
                new PaymentMethod("Debit card", "xx")
        );

        cache.put(user.getId(), paymentMethods);

        PaymentMethodRequest paymentMethodRequest = new PaymentMethodRequest("CASH", "MONEY");
        String payload = mapper.writeValueAsString(paymentMethodRequest);

        //action and validation
        mockMvc.perform(
                patch("/users/{id}/payment-methods", user.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        ).andExpectAll(
                status().isNoContent()
        );


        List pay = cache.get(user.getId(), List.class);

        assertThat(pay)
                .isNullOrEmpty();


        Instant lastReset = cache.getStatistics().getLastReset();
        LocalDateTime invalidCacheMoment = LocalDateTime.ofInstant(lastReset, ZoneId.systemDefault());

        assertThat(invalidCacheMoment)
                .isBefore(LocalDateTime.now());


    }

    @Test
    @DisplayName("must not register payment methods for a non-existent customer")
    void t2() throws Exception {
        //scnary
        PaymentMethodRequest paymentMethodRequest = new PaymentMethodRequest("CASH", "MONEY");
        String payload = mapper.writeValueAsString(paymentMethodRequest);
        //action and validation
        Exception resolvedException = mockMvc.perform(
                        patch("/users/{id}/payment-methods", UUID.randomUUID())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payload)
                )
                .andExpect(
                        status().isNotFound()
                ).andReturn().getResolvedException();

        assertThat(resolvedException)
                .hasMessageContaining("User not exists");
    }
}
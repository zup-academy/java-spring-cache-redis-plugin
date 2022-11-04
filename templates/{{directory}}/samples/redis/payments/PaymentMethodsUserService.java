package {{directory_path_code}}.samples.redis.payments;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentMethodsUserService {
    private final UserRepository userRepository;

    public PaymentMethodsUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Cacheable(value = "user_payment_methods", key = "#userId")
    public List<PaymentMethod> getPaymentMethodsToUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not exists"));

        if (user.getPaymentMethods().isEmpty()) {
            return defaultMethods();
        }

        return user.getPaymentMethods();
    }


    @CacheEvict(value = "user_payment_methods", key = "#userId")
    public void add(UUID userId, PaymentMethod paymentMethod) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not exists"));

        user.add(paymentMethod);
    }

    private List<PaymentMethod> defaultMethods() {
        return List.of(
                new PaymentMethod("Cash", "Money")
        );
    }
}

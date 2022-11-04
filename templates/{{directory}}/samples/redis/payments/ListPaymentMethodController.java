package {{directory_path_code}}.samples.redis.payments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class ListPaymentMethodController {
    private final PaymentMethodsUserService paymentMethodsUserService;

    public ListPaymentMethodController(PaymentMethodsUserService paymentMethodsUserService) {
        this.paymentMethodsUserService = paymentMethodsUserService;
    }


    @GetMapping(value = "/users/{id}/payment-methods")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        try {
            List<PaymentMethod> paymentMethods = paymentMethodsUserService.getPaymentMethodsToUserById(id);
            return ResponseEntity.ok(paymentMethods);

        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}

package {{directory_path_code}}.samples.redis.payments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class RegisterPaymentMethodToUserController {
    private final PaymentMethodsUserService paymentMethodsUserService;

    public RegisterPaymentMethodToUserController(PaymentMethodsUserService paymentMethodsUserService) {
        this.paymentMethodsUserService = paymentMethodsUserService;
    }


    @PatchMapping(value = "/users/{id}/payment-methods")
    public ResponseEntity<?> register(@RequestBody @Valid PaymentMethodRequest request, @PathVariable UUID id) {

        try {
            PaymentMethod paymentMethod = request.toModel();
            paymentMethodsUserService.add(id, paymentMethod);

            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }

    }
}

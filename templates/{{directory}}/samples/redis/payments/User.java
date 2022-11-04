package {{directory_path_code}}.samples.redis.payments;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void add(PaymentMethod paymentMethod){
        this.paymentMethods.add(paymentMethod);
    }
}

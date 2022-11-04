package {{directory_path_code}}.samples.redis.payments;

import java.io.Serializable;
import java.util.UUID;

public class PaymentMethod implements Serializable {

    private String title;
    private String description;

    public PaymentMethod(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public PaymentMethod() {
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

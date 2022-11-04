package {{directory_path_code}}.samples.redis.payments;

import javax.validation.constraints.NotBlank;

public class PaymentMethodRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    public PaymentMethodRequest(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public PaymentMethod toModel() {
        return new PaymentMethod(title, description);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

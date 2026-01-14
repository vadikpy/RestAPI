package org.example.restapi.product.api.request;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.example.restapi.product.api.request.ProductRequest;

public class UpdateProductRequest extends ProductRequest{
    private final long id;


    @JsonCreator
    public UpdateProductRequest(long id, String name) {
        super(name);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

package org.example.restapi.product.support.exception;

import org.example.restapi.product.support.exception.ProductNotFoundException;
import java.util.function.Supplier;

public class ProductExceptionSupplier{
    public static Supplier<ProductNotFoundException> productNotFound(long id) {
        return () -> new ProductNotFoundException(id);
    }
}

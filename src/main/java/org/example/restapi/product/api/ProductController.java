package org.example.restapi.product.api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.example.restapi.product.api.request.ProductRequest;
import org.example.restapi.product.api.response.ProductResponse;
import org.example.restapi.product.service.ProductService;
import org.example.restapi.product.api.request.UpdateProductRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Create product")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.create(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public ResponseEntity<ProductResponse> find(@PathVariable long id) {

        ProductResponse productResponse = productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product")
    public ResponseEntity<ProductResponse> update(@PathVariable long id,  UpdateProductRequest updateProductRequest){
        ProductResponse productResponse = productService.update(id, updateProductRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping
    @Operation(summary = "Find all products")
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> ProductResponses = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ProductResponses);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product")
    public ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
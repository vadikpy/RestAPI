package org.example.restapi.product.service;

import org.example.restapi.product.api.request.UpdateProductRequest;
import org.example.restapi.product.domain.Product;
import org.example.restapi.product.repository.ProductRepository;
import org.example.restapi.product.support.exception.ProductExceptionSupplier;
import org.example.restapi.product.support.ProductMapper;
import org.example.restapi.product.api.request.ProductRequest;
import org.example.restapi.product.api.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;

    }

    public ProductResponse create(ProductRequest productRequest){
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(long id){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(long id, UpdateProductRequest updateProductRequest){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }
    public List<ProductResponse> findAll(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete(long id){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}

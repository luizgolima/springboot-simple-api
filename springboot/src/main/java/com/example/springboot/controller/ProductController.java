package com.example.springboot.controller;

import com.example.springboot.domain.product.dto.ProductDto;
import com.example.springboot.domain.product.model.Product;
import com.example.springboot.domain.product.repository.ProductRepository;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDto productDto,
      UriComponentsBuilder uriBuilder) {
    var productModel = new Product();
    BeanUtils.copyProperties(productDto, productModel);
    var uri = uriBuilder.path("/products/{uuid}").buildAndExpand(productModel.getUuid()).toUri();
    return ResponseEntity.created(uri).body(productModel);
  }

  @GetMapping
  public ResponseEntity<Page<Product>> getAllProducts(
      @PageableDefault(sort = {"name"}) Pageable pageable) {
    return ResponseEntity.ok(productRepository.findAll(pageable));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity getProductById(@PathVariable(value = "uuid") UUID uuid) {
    return ResponseEntity.ok(productRepository.findById(uuid));
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<Product> updateProduct(@PathVariable(value = "uuid") UUID uuid,
      @RequestBody @Valid ProductDto productDto) {
    var productModel = productRepository.findById(uuid);
    BeanUtils.copyProperties(productDto, productModel);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<Product> deleteProduct(@PathVariable(value = "uuid") UUID uuid) {
    productRepository.deleteById(uuid);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}

package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.Exception.ProductsException;
import org.example.models.ProductsReq;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")

public class ProducController {

    @Autowired
    ProductService productService;

    @Operation(summary = "save single products")
    @PostMapping(value="/value")
   public ResponseEntity<Object> saveProducts(@RequestBody ProductsReq products){

        productService.saveProducts(products);
        return new ResponseEntity<>("Successfully Saved to Products", HttpStatus.OK) ;
    }
    @Operation(summary = "fecthProducts")
    @GetMapping(value="/show/{id}")
    public ResponseEntity<ProductsReq> fecthProducts(@PathVariable ("id") Long id) throws ProductsException {

            ProductsReq prod = productService.fetchProducts(id);
            return new ResponseEntity<>(prod, HttpStatus.OK) ;


    }

    @Operation(summary = "save mutiple products")
    @PostMapping(value="/values")
    public ResponseEntity<Object> saveProducts(@RequestBody List<ProductsReq> productList){

        productService.saveProductList(productList);
        return new ResponseEntity<>("Successfully Saved to Products", HttpStatus.OK) ;
    }

    @Operation(summary = "fecthProducts")
    @GetMapping(value="/show")
    public ResponseEntity<List<ProductsReq>> fecthAllProducts(){
        List<ProductsReq> prodList = productService.fetchAllProducts();
        return new ResponseEntity<>(prodList, HttpStatus.OK) ;
    }
}

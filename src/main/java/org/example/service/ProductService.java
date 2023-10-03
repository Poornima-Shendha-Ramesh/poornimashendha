package org.example.service;

import org.example.Exception.ProductsException;
import org.example.models.ProductsReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

     void saveProducts(ProductsReq products);

     ProductsReq fetchProducts(Long id) throws ProductsException;

     void saveProductList(List<ProductsReq> productList);

     List<ProductsReq> fetchAllProducts();
}

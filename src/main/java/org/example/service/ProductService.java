package org.example.service;

import org.example.Exception.ProductsException;
import org.example.models.ProductsReqDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

     void saveProducts(ProductsReqDTO products);

     ProductsReqDTO fetchProducts(Long id) throws ProductsException;

     void saveProductList(List<ProductsReqDTO> productList);

     List<ProductsReqDTO> fetchAllProducts();
}

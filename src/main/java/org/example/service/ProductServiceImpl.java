package org.example.service;

import org.example.Exception.ProductsException;
import org.example.entities.Products;

import org.example.models.ProductsReqDTO;
import org.example.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{

@Autowired
   private ProductRepository productRepo;

    @Override
    public void saveProducts(ProductsReqDTO productsRequest) {
        Products products = new Products();
        BeanUtils.copyProperties(productsRequest,products);
        productRepo.save(products);
    }

    @Override
    public ProductsReqDTO fetchProducts(Long id) throws ProductsException {
        ProductsReqDTO products = new ProductsReqDTO();
  try{
    var prod =    productRepo.findById(id).get();
    BeanUtils.copyProperties(prod,products);

}catch (Exception e){
throw new ProductsException(e.getMessage());
}
        return products;
    }

    @Override
    public void saveProductList(List<ProductsReqDTO> productList) {
        List<Products> productsList =  new ArrayList<>();
        for(ProductsReqDTO product : productList){
            Products products= new Products();
            BeanUtils.copyProperties(product,products);
            productsList.add(products);
        }

        productRepo.saveAll(productsList);
    }

    @Override
    public List<ProductsReqDTO> fetchAllProducts() {
        List<ProductsReqDTO> productsListResp =  new ArrayList<>();
        List<Products>  productsList = productRepo.findAll();
        for(Products product : productsList){
            ProductsReqDTO products= new ProductsReqDTO();
            BeanUtils.copyProperties(product,products);
            productsListResp.add(products);
        }
        return productsListResp;
    }
}

package br.com.devcave.product.controller;

import br.com.devcave.product.domain.Product;
import br.com.devcave.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id){
        Product product = productRepository.findOne(id);
        return product;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public List<Product> getProductByCategory(@PathVariable("id") Long id){
        List<Product> productList = productRepository.findByCategory_id(id);
        return productList;
    }

    @RequestMapping(value = "/price/{price}/", method = RequestMethod.GET)
    public List<Product> getProductByPrice(@PathVariable("price") BigDecimal price){
        List<Product> productList = productRepository.findByPriceLessThanEqual(price);
        return productList;
    }

}

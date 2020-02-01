package org.qasimovey.controller;

import org.qasimovey.model.Product;
import org.qasimovey.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductContoller {
    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    private void dbinit(){
        Product p=new Product();
        p.setId("1232131111");
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("brand","Acer ASPIRE");
        map.put("color","green");
        map.put("price","1313");
        map.put("currency","$");
        p.setOzellik(map);

        productRepository.save(p);

    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> siyahi=productRepository.findAll();
        return ResponseEntity.ok().body(siyahi);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getSpecificProduct(@PathVariable("product_id") String id){
        Product product=productRepository.findById(id).get();
        return ResponseEntity.ok().body(product);

    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product p= productRepository.save(product);
        return ResponseEntity.ok(p);
    }
}

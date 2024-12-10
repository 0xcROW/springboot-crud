package com.example.nobsv2.product.headers;

import com.example.nobsv2.product.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "BR") String region) {

        if(region == null) {
            return "Country: Unknown";
        }

        return "Country: " + region;
    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("Product 1");
        product.setDescription("Product description with 20 chars long");
        product.setPrice(100.0);
        return ResponseEntity.ok(product);
    }

}

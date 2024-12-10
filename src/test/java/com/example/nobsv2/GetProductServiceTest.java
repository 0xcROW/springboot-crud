package com.example.nobsv2;

import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private GetProductService getProductService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnProductDTOWhenProductExists() {
        Product existingProduct = new Product();
        existingProduct.setId(1);
        existingProduct.setName("Product Name");
        existingProduct.setDescription("Product Description That Is Longer Than 20 Chars");
        existingProduct.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(existingProduct));

        ProductDTO expectedProductDTO = new ProductDTO(existingProduct);
        ResponseEntity<ProductDTO> expectedResponse = ResponseEntity.ok(expectedProductDTO);

        ResponseEntity<ProductDTO> actualResponse = getProductService.execute(1);

        assertEquals(expectedResponse, actualResponse);
        verify(productRepository, times(1)).findById(1);
    }
}
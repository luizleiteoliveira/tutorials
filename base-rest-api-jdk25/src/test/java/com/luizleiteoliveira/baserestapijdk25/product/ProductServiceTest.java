package com.luizleiteoliveira.baserestapijdk25.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void shouldSaveAndFindProduct() {
        Product product = new Product(null, "Teclado", 199.90);
        Product saved = productService.save(product);
        assertNotNull(saved.getId());

        Product found = productService.findById(saved.getId());
        assertEquals("Teclado", found.getName());
    }

    @Test
    void shouldCacheProductAfterFirstFind() {
        Product saved = productService.save(new Product(null, "Monitor", 1500.00));
        productService.findById(saved.getId());

        var cached = cacheManager.getCache("products").get(saved.getId());
        assertNotNull(cached);
        assertEquals("Monitor", ((Product) cached.get()).getName());
    }

    @Test
    void shouldEvictCacheOnSave() {
        Product saved = productService.save(new Product(null, "Headset", 350.00));
        productService.findById(saved.getId());

        saved.setName("Headset Pro");
        saved.setPrice(450.00);
        productService.save(saved);

        var cached = cacheManager.getCache("products").get(saved.getId());
        assertNull(cached);
    }

    @Test
    void shouldClearAllCacheEntries() {
        Product saved = productService.save(new Product(null, "Webcam", 250.00));
        productService.findById(saved.getId());

        productService.clearCache();

        var cached = cacheManager.getCache("products").get(saved.getId());
        assertNull(cached);
    }

    @Test
    void shouldLoadInitialData() {
        var products = productService.findAll();
        assertTrue(products.size() >= 5);
    }
}

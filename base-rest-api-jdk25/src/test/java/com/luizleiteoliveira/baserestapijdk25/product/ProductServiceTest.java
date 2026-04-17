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
        Product saved = productService.save(new Product(null, "Teclado", 199.90));
        assertNotNull(saved.id());

        Product found = productService.findById(saved.id());
        assertEquals("Teclado", found.name());
    }

    @Test
    void shouldCacheProductAfterFirstFind() {
        Product saved = productService.save(new Product(null, "Monitor", 1500.00));
        productService.findById(saved.id());

        var cached = cacheManager.getCache("products").get(saved.id());
        assertNotNull(cached);
        assertEquals("Monitor", ((Product) cached.get()).name());
    }

    @Test
    void shouldEvictCacheOnSave() {
        Product saved = productService.save(new Product(null, "Headset", 350.00));
        productService.findById(saved.id()); // popula cache

        productService.save(new Product(saved.id(), "Headset Pro", 450.00));

        var cached = cacheManager.getCache("products").get(saved.id());
        assertNull(cached);
    }

    @Test
    void shouldClearAllCacheEntries() {
        Product saved = productService.save(new Product(null, "Webcam", 250.00));
        productService.findById(saved.id()); // popula cache

        productService.clearCache();

        var cached = cacheManager.getCache("products").get(saved.id());
        assertNull(cached);
    }
}

package com.luizleiteoliveira.baserestapijdk25.product;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private long sequence = 0;

    @Cacheable(value = "products", key = "#id")
    public Product findById(Long id) {
        return store.get(id);
    }

    @CacheEvict(value = "products", key = "#product.id")
    public Product save(Product product) {
        if (product.id() == null) {
            product = new Product(++sequence, product.name(), product.price());
        }
        store.put(product.id(), product);
        return product;
    }

    @CacheEvict(value = "products", allEntries = true)
    public void clearCache() {
    }
}

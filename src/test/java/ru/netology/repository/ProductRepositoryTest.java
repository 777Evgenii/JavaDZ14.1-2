package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    @Test
    public void shouldSaveOneItem() {
        ProductRepository repository = new ProductRepository();

        Product product = new Product();
        repository.save(product);

        Product[] expected = new Product[]{product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteOneItem() {
        Product product1 = new Product(1, "Product1", 10);
        Product product2 = new Product(2, "Product2", 20);

        ProductRepository repository = new ProductRepository();
        repository.save(product1);
        repository.save(product2);
        repository.removeById(1);

        Product[] expected = new Product[]{product2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}

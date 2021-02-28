package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "Чистый код", 364, "Роберт Мартин");
    Product book2 = new Book(2, "Искусство программирования", 3298, "Дональд Кнут");

    @Test
    void shouldThrowNotFoundException() {
        repository.save(book1);
        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }

    @Test
    void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

}
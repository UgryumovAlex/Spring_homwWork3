package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class ProductsRepository {
    /*
        Если нам нужно будет по тексту задачи искать товар по ID, то может лучше через Map сделать,
        чтобы при поиске перебором не заниматься?

        private List<Product> products;
    */
    private Map<Integer, Product> products;
    private static int id = 1;

    @Autowired
    public void setProducts() {
        products = new HashMap<>();

        Product p1 = new Product();
        p1.setId(id++);
        p1.setTitle("Холодильник");
        p1.setCost(50000);

        Product p2 = new Product();
        p2.setId(id++);
        p2.setTitle("Телевизор");
        p2.setCost(60000);

        Product p3 = new Product();
        p3.setId(id++);
        p3.setTitle("Стиральная машина");
        p3.setCost(70000);

        products.put(p1.getId(), p1 );
        products.put(p2.getId(), p2 );
        products.put(p3.getId(), p3 );
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void addProduct(Product newProduct) {
        newProduct.setId(id++);
        products.put(newProduct.getId(), newProduct);
    }
}

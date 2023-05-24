package ro.unibuc.auction.services;

import java.util.List;
import java.util.ArrayList;
import ro.unibuc.auction.models.Product;

public class ProductService implements CRUDService <Product> {
    private List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void create(Product product) {
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public void update(Product oldProduct, Product newProduct) {
    }

    @Override
    public void delete(Product product) {
    }
}

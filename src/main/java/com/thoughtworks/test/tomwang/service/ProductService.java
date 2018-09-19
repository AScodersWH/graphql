package service;

import com.thoughtworks.test.controller.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoughtworks.test.controller.repository.UserRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepository;

    public List<Product> getAllProducts(Integer userId) {
        return userRepository.findOneById(userId).getProducts();
    }

    public Product getOneByName(Integer userId, String name) {
        List<Product> products = userRepository.findOneById(userId).getProducts();
        for (Product product : products) {
            if (product.getName().equals(name)) return product;
        }
        return null;
    }

    public List<Product> deleteProductByName(Integer userId, String name) {
        List<Product> products = userRepository.findOneById(userId).getProducts();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                break;
            }
        }
        userRepository.findOneById(userId).setProducts(products);
        userRepository.save(userRepository.findOneById(userId));
        return products;
    }

    public List<Product> store(Integer userId, Product product) {
        List<Product> products = userRepository.findOneById(userId).getProducts();
        products.add(product);
        userRepository.findOneById(userId).setProducts(products);
        userRepository.save(userRepository.findOneById(userId));
        return products;
    }
}

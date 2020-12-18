package pl.io2.inwentaryzator.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.io2.inwentaryzator.user.Worker;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAllProducts();

    }
}

package leonardoegito.minhalistaorganica.service;

import leonardoegito.minhalistaorganica.model.Product;
import leonardoegito.minhalistaorganica.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return this.productRepository.save(product);
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getByID(Long id){
        return this.productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }

}

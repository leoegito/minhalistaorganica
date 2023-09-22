package leonardoegito.minhalistaorganica.controller;

import leonardoegito.minhalistaorganica.model.Product;
import leonardoegito.minhalistaorganica.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();
    }

    @GetMapping("/list")
    public List<Product> getProductList(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") Long id) throws Exception{
        return ResponseEntity.ok(this.productService.getByID(id).orElseThrow(
                () -> new Exception("Product not found")
        ));
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Optional<Product> productOptional = this.productService.getByID(product.getId());
        if(productOptional.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Product savedProduct = this.productService.saveProduct(product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Optional<Product> productOptional = this.productService.getByID(id);
        if(productOptional.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }

        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}

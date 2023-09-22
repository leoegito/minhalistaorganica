package leonardoegito.minhalistaorganica.repository;

import leonardoegito.minhalistaorganica.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface ProductRepository extends JpaRepository<Product, Long> {
}

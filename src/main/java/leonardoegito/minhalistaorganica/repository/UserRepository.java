package leonardoegito.minhalistaorganica.repository;

import leonardoegito.minhalistaorganica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findById(Long id);
}
package leonardoegito.minhalistaorganica.service;

import jakarta.persistence.EntityNotFoundException;
import leonardoegito.minhalistaorganica.model.User;
import leonardoegito.minhalistaorganica.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long idUser){
//        Optional<User> obj = userRepository;
//        return obj.orElseThrow() -> new ConfigDataResourceNotFoundException(id);
        return userRepository.findById(idUser);
    }

    public User insert(User user){
        if(userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("User already exists.");
        }
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("ID not found.", 1);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Long id, User user){
        try{
            User tempUser = userRepository.getReferenceById(id);
        } catch (EntityNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void updateData(User updatedUser, User userNewData){
        updatedUser.setEmail(userNewData.getEmail());
        updatedUser.setName(userNewData.getName());
    }





}

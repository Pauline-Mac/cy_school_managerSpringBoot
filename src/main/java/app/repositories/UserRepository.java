package app.repositories;

import org.springframework.data.repository.CrudRepository;
import app.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findByUserId(Long user_id);

    String getPasswordByEmail(String email);

    User findByEmail(String email);
    // User findByEmail(String email);
}
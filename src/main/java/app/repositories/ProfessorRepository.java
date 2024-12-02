
package app.repositories;

import app.models.Course;
import app.models.Professor;
import app.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    Professor getProfessorByUserId(Long userId);

    @Query("SELECT p FROM Professor p WHERE " +
            "(:firstname IS NULL OR LOWER(p.firstName) LIKE LOWER(CONCAT(:firstname, '%'))) AND " +
            "(:lastname IS NULL OR LOWER(p.lastName) LIKE LOWER(CONCAT(:lastname, '%'))) AND " +
            "(:email IS NULL OR LOWER(p.email) LIKE LOWER(CONCAT(:email, '%')))")
    List<Professor> searchProfessorByCriteria(String firstname, String lastname, String email);

    List<Professor> findAllByEmailEquals(String email);
}
